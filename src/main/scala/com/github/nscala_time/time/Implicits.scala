/**
 * Copyright 2009 Jorge Ortiz
 * Copyright 2009 Barry Kaplan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/
package com.github.nscala_time.time

import java.util.Date
import org.joda.time._
import base.{BaseSingleFieldPeriod, AbstractDateTime, AbstractInstant, AbstractPartial}
import org.joda.time.format.DateTimeFormatter
import org.joda.time.field.AbstractReadableInstantFieldProperty
import scala.concurrent.duration.{ Duration => SDuration }

object Implicits extends Implicits
object BuilderImplicits extends BuilderImplicits
object IntImplicits extends IntImplicits
object StringImplicits extends StringImplicits
object OrderingImplicits extends OrderingImplicits
object JodaImplicits extends JodaImplicits

trait Implicits extends BuilderImplicits with IntImplicits with StringImplicits with DateImplicits with ScalaDurationImplicits with OrderingImplicits with JodaImplicits

trait BuilderImplicits {
  implicit def forcePeriod(builder: DurationBuilder): Period =
    builder.underlying
  implicit def forceDuration(builder: DurationBuilder): Duration =
    builder.underlying.toStandardDuration
}

trait IntImplicits {
  implicit def richInt(n: Int): RichInt = new com.github.nscala_time.time.RichInt(n)
  implicit def richLong(n: Long): RichLong = new com.github.nscala_time.time.RichLong(n)
}

trait StringImplicits {
  implicit def richString(s: String): RichString = new com.github.nscala_time.time.RichString(s)
}

trait DateImplicits {
  implicit def richDate(d: Date): RichDate = new com.github.nscala_time.time.RichDate(d)
}

trait ScalaDurationImplicits {
  implicit def richSDuration(d: SDuration): RichSDuration = new com.github.nscala_time.time.RichSDuration(d)
}

trait OrderingImplicits extends LowPriorityOrderingImplicits {
  implicit val DateTimeOrdering: Ordering[DateTime] = ReadableInstantOrdering[DateTime]
  implicit val LocalDateOrdering: Ordering[LocalDate] = ReadablePartialOrdering[LocalDate]
  implicit val LocalTimeOrdering: Ordering[LocalTime] = ReadablePartialOrdering[LocalTime]
  implicit val LocalDateTimeOrdering: Ordering[LocalDateTime] = ReadablePartialOrdering[LocalDateTime]
  implicit val DurationOrdering: Ordering[Duration] = ReadableDurationOrdering[Duration]
}

trait LowPriorityOrderingImplicits {
  implicit def ReadableInstantOrdering[A <: ReadableInstant]: Ordering[A] = order[A, ReadableInstant]
  implicit def ReadablePartialOrdering[A <: ReadablePartial]: Ordering[A] = order[A, ReadablePartial]
  implicit def BaseSingleFieldPeriodOrdering[A <: BaseSingleFieldPeriod]: Ordering[A] = order[A, BaseSingleFieldPeriod]
  implicit def ReadableDurationOrdering[A <: ReadableDuration]: Ordering[A] = order[A, ReadableDuration]
  private def order[A, B <: Comparable[B]](implicit ev: A <:< B): Ordering[A] = Ordering.by[A, B](ev)
}

trait JodaImplicits {
  implicit def richAbstractDateTime(dt: AbstractDateTime): RichAbstractDateTime = new RichAbstractDateTime(dt)
  implicit def richAbstractInstant(in: AbstractInstant): RichAbstractInstant = new RichAbstractInstant(in)
  implicit def richAbstractPartial(pt: AbstractPartial): RichAbstractPartial = new RichAbstractPartial(pt)
  implicit def richAbstractReadableInstantFieldProperty(pty: AbstractReadableInstantFieldProperty): RichAbstractReadableInstantFieldProperty = new RichAbstractReadableInstantFieldProperty(pty)
  implicit def richChronology(ch: Chronology): RichChronology = new RichChronology(ch)
  implicit def richDateTime(dt: DateTime): RichDateTime = new RichDateTime(dt)
  implicit def richDateTimeFormatter(fmt: DateTimeFormatter): RichDateTimeFormatter = new RichDateTimeFormatter(fmt)
  implicit def richDateTimeProperty(pty: DateTime.Property): RichDateTimeProperty = new RichDateTimeProperty(pty)
  implicit def richDateTimeZone(zone: DateTimeZone): RichDateTimeZone = new RichDateTimeZone(zone)
  implicit def richDuration(dur: Duration): RichDuration = new RichDuration(dur)
  implicit def richInstant(in: Instant): RichInstant = new RichInstant(in)
  implicit def richInterval(in: Interval): RichInterval = new RichInterval(in)
  implicit def richLocalDate(ld: LocalDate): RichLocalDate = new RichLocalDate(ld)
  implicit def richLocalDateProperty(pty: LocalDate.Property): RichLocalDateProperty = new RichLocalDateProperty(pty)
  implicit def richLocalDateTime(dt: LocalDateTime): RichLocalDateTime = new RichLocalDateTime(dt)
  implicit def richLocalDateTimeProperty(pty: LocalDateTime.Property): RichLocalDateTimeProperty = new RichLocalDateTimeProperty(pty)
  implicit def richLocalTime(lt: LocalTime): RichLocalTime = new RichLocalTime(lt)
  implicit def richLocalTimeProperty(pty: LocalTime.Property): RichLocalTimeProperty = new RichLocalTimeProperty(pty)
  implicit def richPartial(pt: Partial): RichPartial = new RichPartial(pt)
  implicit def richPartialProperty(pty: Partial.Property): RichPartialProperty = new RichPartialProperty(pty)
  implicit def richPeriod(per: Period): RichPeriod = new RichPeriod(per)
  implicit def richReadableDateTime(dt: ReadableDateTime): RichReadableDateTime = new RichReadableDateTime(dt)
  implicit def richReadableDuration(dur: ReadableDuration): RichReadableDuration = new RichReadableDuration(dur)
  implicit def richReadableInstant(in: ReadableInstant): RichReadableInstant = new RichReadableInstant(in)
  implicit def richReadableInterval(in: ReadableInterval): RichReadableInterval = new RichReadableInterval(in)
  implicit def richReadablePartial(rp: ReadablePartial): RichReadablePartial = new RichReadablePartial(rp)
  implicit def richReadablePeriod(per: ReadablePeriod): RichReadablePeriod = new RichReadablePeriod(per)
}
