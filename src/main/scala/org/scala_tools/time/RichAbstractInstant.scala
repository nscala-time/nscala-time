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

import java.util.Date
import org.joda.time._
import org.joda.time.base.AbstractInstant

class RichAbstractInstant(underlying: AbstractInstant) {
  def date: Date =
    underlying.toDate
  def dateTime: DateTime =
    underlying.toDateTime
  def dateTime(chronology: Chronology): DateTime =
    underlying.toDateTime(chronology)
  def dateTime(zone: DateTimeZone): DateTime =
    underlying.toDateTime(zone)
  def dateTimeISO: DateTime =
    underlying.toDateTimeISO
  def instant: Instant =
    underlying.toInstant
  def mutableDateTime: MutableDateTime =
    underlying.toMutableDateTime
  def mutableDateTime(chronology: Chronology): MutableDateTime =
    underlying.toMutableDateTime(chronology)
  def mutableDateTime(zone: DateTimeZone): MutableDateTime =
    underlying.toMutableDateTime(zone)
  def mutableDateTimeISO: MutableDateTime =
    underlying.toMutableDateTimeISO
}
