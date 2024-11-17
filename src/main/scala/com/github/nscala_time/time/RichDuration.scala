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
import scala.concurrent.duration.{ MILLISECONDS , FiniteDuration }

class RichDuration(private val underlying: Duration) extends AnyVal {

  def days: Long = underlying.getStandardDays

  def hours: Long = underlying.getStandardHours

  def millis: Long = underlying.getMillis

  def minutes: Long = underlying.getStandardMinutes

  def seconds: Long = underlying.getStandardSeconds

  def unary_- : Duration = underlying.negated

  def -(amount: Long): Duration = underlying.minus(amount)

  def -(amount: ReadableDuration): Duration = underlying.minus(amount)

  def +(amount: Long): Duration = underlying.plus(amount)

  def +(amount: ReadableDuration): Duration = underlying.plus(amount)

  def /(divisor: Long): Duration = underlying.dividedBy(divisor)

  def *(multiplicand: Long): Duration = underlying.multipliedBy(multiplicand)

  def toScalaDuration: FiniteDuration = FiniteDuration(underlying.getMillis, MILLISECONDS)

}
