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

private[time] object DurationBuilder {
  def apply(underlying: Period): DurationBuilder =
    new DurationBuilder(underlying)
}

// Duration Builder
sealed private[time] class DurationBuilder(val underlying: Period) {
  // DurationBuilder + DurationBuilder = DurationBuilder
  // This is the only operation that can maintain a DurationBuilder
  // Everything else kicks us out to DateTime, Duration, or Period
  def +(that: DurationBuilder): DurationBuilder =
    DurationBuilder(this.underlying.plus(that.underlying))

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
  def toDuration: Duration =
    underlying.toStandardDuration  
  def toPeriod: Period =
    underlying
    
  def -(period: ReadablePeriod): Period =
    underlying.minus(period)
  def +(period: ReadablePeriod): Period =
    underlying.plus(period)

  def millis: Long =
    underlying.toStandardDuration.getMillis
  def seconds: Long =
    underlying.toStandardDuration.getStandardSeconds
  def -(amount: Long): Duration =
    underlying.toStandardDuration.minus(amount)
  def -(amount: ReadableDuration): Duration =
    underlying.toStandardDuration.minus(amount)
  def +(amount: Long): Duration =
    underlying.toStandardDuration.plus(amount)
  def +(amount: ReadableDuration): Duration =
    underlying.toStandardDuration.plus(amount)
}
