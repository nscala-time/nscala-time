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

class RichPeriod(underlying: Period) {
  def days: Int =
    underlying.getDays
  def hours: Int =
    underlying.getHours
  def millis: Int =
    underlying.getMillis
  def minutes: Int =
    underlying.getMinutes
  def months: Int =
    underlying.getMonths
  def seconds: Int =
    underlying.getSeconds
  def weeks: Int =
    underlying.getWeeks
  def years: Int =
    underlying.getYears
  def -(period: ReadablePeriod): Period =
    underlying.minus(period)
  def +(period: ReadablePeriod): Period =
    underlying.plus(period)
  def ago: DateTime =
    StaticDateTime.now.minus(underlying)
  def later: DateTime =
    StaticDateTime.now.plus(underlying)
  def from(dt: DateTime): DateTime =
    dt.plus(underlying)
  def before(dt: DateTime): DateTime =
    dt.minus(underlying)
  
  def standardDuration: Duration =
    underlying.toStandardDuration
}
