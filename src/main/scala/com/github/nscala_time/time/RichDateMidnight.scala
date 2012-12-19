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

class RichDateMidnight(val underlying: DateMidnight) extends AnyRef with PimpedType[DateMidnight] {

  def -(duration: Long): DateMidnight = underlying.minus(duration)

  def -(duration: ReadableDuration): DateMidnight = underlying.minus(duration)

  def -(period: ReadablePeriod): DateMidnight = underlying.minus(period)

  def -(builder: DurationBuilder): DateMidnight = underlying.minus(builder.underlying)

  def +(duration: Long): DateMidnight = underlying.plus(duration)

  def +(duration: ReadableDuration): DateMidnight = underlying.plus(duration)

  def +(period: ReadablePeriod): DateMidnight = underlying.plus(period)

  def +(builder: DurationBuilder): DateMidnight = underlying.plus(builder.underlying)
}
