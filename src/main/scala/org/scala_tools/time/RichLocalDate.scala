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
package org.scala_tools.time

import org.joda.time._

class RichLocalDate(underlying: LocalDate) {
  def -(period: ReadablePeriod): LocalDate =
    underlying.minus(period)
  def -(builder: DurationBuilder): LocalDate =
    underlying.minus(builder.underlying)
  def +(period: ReadablePeriod): LocalDate =
    underlying.plus(period)
  def +(builder: DurationBuilder): LocalDate =
    underlying.plus(builder.underlying)

  def day: LocalDate.Property = underlying.dayOfMonth
  def week: LocalDate.Property = underlying.weekOfWeekyear
  def month: LocalDate.Property = underlying.monthOfYear
  def year: LocalDate.Property = underlying.year
  def century: LocalDate.Property = underlying.centuryOfEra
  def era: LocalDate.Property = underlying.era

  def withDay(day: Int) = underlying.withDayOfMonth(day)
  def withWeek(week: Int) = underlying.withWeekOfWeekyear(week)
  def withMonth(month: Int) = underlying.withMonthOfYear(month)
  def withYear(year: Int) = underlying.withYear(year)
  def withCentury(century: Int) = underlying.withCenturyOfEra(century)
  def withEra(era: Int) = underlying.withEra(era)
  
  def interval = underlying.toInterval
}
