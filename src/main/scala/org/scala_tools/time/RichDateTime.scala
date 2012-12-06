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

class RichDateTime(underlying: DateTime) {
  def -(duration: Long): DateTime =
    underlying.minus(duration)
  def -(duration: ReadableDuration): DateTime =
    underlying.minus(duration)
  def -(period: ReadablePeriod): DateTime =
    underlying.minus(period)
  def -(builder: DurationBuilder): DateTime =
    underlying.minus(builder.underlying)
  def +(duration: Long): DateTime =
    underlying.plus(duration)
  def +(duration: ReadableDuration): DateTime =
    underlying.plus(duration)
  def +(period: ReadablePeriod): DateTime =
    underlying.plus(period)
  def +(builder: DurationBuilder): DateTime =
    underlying.plus(builder.underlying)
  
  def second: DateTime.Property = underlying.secondOfMinute
  def minute: DateTime.Property = underlying.minuteOfHour
  def hour: DateTime.Property = underlying.hourOfDay
  def day: DateTime.Property = underlying.dayOfMonth
  def week: DateTime.Property = underlying.weekOfWeekyear
  def month: DateTime.Property = underlying.monthOfYear
  def year: DateTime.Property = underlying.year
  def century: DateTime.Property = underlying.centuryOfEra
  def era: DateTime.Property = underlying.era
  
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
