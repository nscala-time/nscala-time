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
package com.github.kmizu.nscala.time

import org.joda.time._
import com.github.kmizu.nscala.PimpedType

class RichReadableInstant(val underlying: ReadableInstant) extends Ordered[ReadableInstant]
  with PimpedType[ReadableInstant] {

  def chronology: Chronology = underlying.getChronology

  def millis: Long = underlying.getMillis

  def zone: DateTimeZone = underlying.getZone

  override def compare(that: ReadableInstant): Int = underlying.compareTo(that)
  
  def to(other: ReadableInstant): Interval = new Interval(underlying, other)

  def instant: Instant = underlying.toInstant

}
