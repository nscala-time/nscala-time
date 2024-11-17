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

class RichReadableInterval(val underlying: ReadableInterval) extends AnyVal {

  def chronology: Chronology = underlying.getChronology

  def end: DateTime = underlying.getEnd

  def endMillis: Long = underlying.getEndMillis

  def start: DateTime = underlying.getStart

  def startMillis: Long = underlying.getStartMillis

  def duration: Duration = underlying.toDuration

  def millis: Long = underlying.toDuration.getMillis
  // TODO: Should > and > be added as aliases for isAfter and isBefore?
  //   could be convenient, or just confusing because this isn't Ordered.
}
