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
import org.joda.time.format.PeriodFormatter

object StaticPeriod extends StaticPeriod

trait StaticPeriod {
  def parse(str: String) = Period.parse(str)
  def parse(str: String, formatter: PeriodFormatter) = Period.parse(str, formatter)

  def days(days: Int) = Period.days(days)
  def fieldDifference(start: ReadablePartial, end: ReadablePartial) =
    Period.fieldDifference(start, end)
  def hours(hours: Int) = Period.hours(hours)
  def millis(millis: Int) = Period.millis(millis)
  def minutes(minutes: Int) = Period.minutes(minutes)
  def months(months: Int) = Period.months(months)
  def seconds(seconds: Int) = Period.seconds(seconds)
  def weeks(weeks: Int) = Period.weeks(weeks)
  def years(years: Int) = Period.years(years)
}
