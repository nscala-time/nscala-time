/**
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

import org.joda.time._
import com.github.nscala_time.PimpedType

class RichLocalTime(val underlying: LocalTime) extends AnyRef with PimpedType[LocalTime] {

  def -(period: ReadablePeriod): LocalTime = underlying.minus(period)

  def -(builder: DurationBuilder): LocalTime = underlying.minus(builder.underlying)

  def +(period: ReadablePeriod): LocalTime = underlying.plus(period)

  def +(builder: DurationBuilder): LocalTime = underlying.plus(builder.underlying)

  def second: LocalTime.Property = underlying.secondOfMinute

  def minute: LocalTime.Property = underlying.minuteOfHour

  def hour: LocalTime.Property = underlying.hourOfDay

  def withSecond(second: Int) = underlying.withSecondOfMinute(second)

  def withMinute(minute: Int) = underlying.withMinuteOfHour(minute)

  def withHour(hour: Int) = underlying.withHourOfDay(hour)
}
