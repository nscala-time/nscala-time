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

class RichInt(val underlying: Int) extends AnyVal with PimpedType[Int] {
  // These units of time can build durations or periods.
  // At most we lose a leap second. (Unless someone adopts
  // leap minutes).
  def millis  = DurationBuilder(Period.millis(underlying))

  def seconds = DurationBuilder(Period.seconds(underlying))

  def minutes = DurationBuilder(Period.minutes(underlying))

  def hours   = DurationBuilder(Period.hours(underlying))

  // These units of time can only be periods. At this
  // point if we made durations automatically we'd start
  // getting into trouble with daylight savings time,
  // monthly differences, leap years, etc.
  def days   = Period.days(underlying)
  def weeks  = Period.weeks(underlying)
  def months = Period.months(underlying)
  def years  = Period.years(underlying)

  // See above.
  def milli  = DurationBuilder(Period.millis(underlying))
  def second = DurationBuilder(Period.seconds(underlying))
  def minute = DurationBuilder(Period.minutes(underlying))
  def hour   = DurationBuilder(Period.hours(underlying))

  // See above.
  def day   = Period.days(underlying)
  def week  = Period.weeks(underlying)
  def month = Period.months(underlying)
  def year  = Period.years(underlying)

  def *(period: Period) = period.multipliedBy(underlying)

}
