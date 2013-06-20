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
import org.joda.time.format.DateTimeFormatter
import java.util.{Calendar, Date}

object StaticYearMonth extends StaticYearMonth

trait StaticYearMonth {
  type Property = YearMonth.Property

  def fromCalendarFields(calendar: Calendar) = YearMonth.fromCalendarFields(calendar)
  def fromDateFields(date: Date) = YearMonth.fromDateFields(date)
  def now = YearMonth.now()
  def now(chronology: Chronology) = YearMonth.now(chronology)
  def now(zone: DateTimeZone) = YearMonth.now(zone)
  def parse(str: String) = YearMonth.parse(str)
  def parse(str: String, formatter: DateTimeFormatter) = YearMonth.parse(str, formatter)
}

