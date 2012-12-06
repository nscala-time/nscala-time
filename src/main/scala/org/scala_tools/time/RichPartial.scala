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

class RichPartial(underlying: Partial) {
  def formatter = underlying.getFormatter
  
  def -(period: ReadablePeriod): Partial =
    underlying.minus(period)
  def -(builder: DurationBuilder): Partial =
    underlying.minus(builder.underlying)
  def +(period: ReadablePeriod): Partial =
    underlying.plus(period)
  def +(builder: DurationBuilder): Partial =
    underlying.plus(builder.underlying)
}
