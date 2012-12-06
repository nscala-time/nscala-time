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
package org.scala_tools.time

import org.joda.time._

class RichLocalDateTime(underlying: LocalDateTime) {
  def -(duration: ReadableDuration): LocalDateTime =
    underlying.minus(duration)
  def -(period: ReadablePeriod): LocalDateTime =
    underlying.minus(period)
  def -(builder: DurationBuilder): LocalDateTime =
    underlying.minus(builder.underlying)
  def +(duration: ReadableDuration): LocalDateTime =
    underlying.plus(duration)
  def +(period: ReadablePeriod): LocalDateTime =
    underlying.plus(period)
  def +(builder: DurationBuilder): LocalDateTime =
    underlying.plus(builder.underlying)

  def second: LocalDateTime.Property = underlying.secondOfMinute
  def minute: LocalDateTime.Property = underlying.minuteOfHour
  def hour: LocalDateTime.Property = underlying.hourOfDay
  def day: LocalDateTime.Property = underlying.dayOfMonth
  def week: LocalDateTime.Property = underlying.weekOfWeekyear
  def month: LocalDateTime.Property = underlying.monthOfYear
  def year: LocalDateTime.Property = underlying.year
  def century: LocalDateTime.Property = underlying.centuryOfEra
  def era: LocalDateTime.Property = underlying.era

  def withSecond(second: Int) = underlying.withSecondOfMinute(second)
  def withMinute(minute: Int) = underlying.withMinuteOfHour(minute)
  def withHour(hour: Int) = underlying.withHourOfDay(hour)
  def withDay(day: Int) = underlying.withDayOfMonth(day)
  def withWeek(week: Int) = underlying.withWeekOfWeekyear(week)
  def withMonth(month: Int) = underlying.withMonthOfYear(month)
  def withYear(year: Int) = underlying.withYear(year)
  def withCentury(century: Int) = underlying.withCenturyOfEra(century)
  def withEra(era: Int) = underlying.withEra(era)
}
