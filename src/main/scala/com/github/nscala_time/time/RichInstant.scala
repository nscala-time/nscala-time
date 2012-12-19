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

class RichInstant(val underlying: Instant) extends AnyRef with PimpedType[Instant] {

  def -(duration: Long): Instant = underlying.minus(duration)

  def -(duration: ReadableDuration): Instant = underlying.minus(duration)

  def +(duration: Long): Instant = underlying.plus(duration)

  def +(duration: ReadableDuration): Instant = underlying.plus(duration)

}
