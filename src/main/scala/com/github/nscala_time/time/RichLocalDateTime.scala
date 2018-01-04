/**
 * Copyright 2009 Jorge Ortiz
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

import org.joda.time._
import com.github.nscala_time.PimpedType

private[time] class RichLocalDateTime(val underlying: LocalDateTime) extends AnyVal with PimpedType[LocalDateTime] {
  private[this] type Property = LocalDateTime.Property

  def -(duration: ReadableDuration): LocalDateTime = underlying.minus(duration)
  def -(period: ReadablePeriod): LocalDateTime     = underlying.minus(period)
  def -(builder: DurationBuilder): LocalDateTime   = underlying.minus(builder.underlying)

  def +(duration: ReadableDuration): LocalDateTime = underlying.plus(duration)
  def +(period: ReadablePeriod): LocalDateTime     = underlying.plus(period)
  def +(builder: DurationBuilder): LocalDateTime   = underlying.plus(builder.underlying)

  def second: Property  = underlying.secondOfMinute
  def minute: Property  = underlying.minuteOfHour
  def hour: Property    = underlying.hourOfDay
  def day: Property     = underlying.dayOfMonth
  def week: Property    = underlying.weekOfWeekyear
  def month: Property   = underlying.monthOfYear
  def year: Property    = underlying.year
  def century: Property = underlying.centuryOfEra
  def era: Property     = underlying.era

  def withSecond(second: Int)   = underlying.withSecondOfMinute(second)
  def withMinute(minute: Int)   = underlying.withMinuteOfHour(minute)
  def withHour(hour: Int)       = underlying.withHourOfDay(hour)
  def withDay(day: Int)         = underlying.withDayOfMonth(day)
  def withWeek(week: Int)       = underlying.withWeekOfWeekyear(week)
  def withMonth(month: Int)     = underlying.withMonthOfYear(month)
  def withYear(year: Int)       = underlying.withYear(year)
  def withCentury(century: Int) = underlying.withCenturyOfEra(century)
  def withEra(era: Int)         = underlying.withEra(era)
}
