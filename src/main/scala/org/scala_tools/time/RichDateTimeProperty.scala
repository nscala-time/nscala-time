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

import java.util.Locale
import org.joda.time._

class RichDateTimeProperty(underlying: DateTime.Property) {
  def dateTime: DateTime =
    underlying.getDateTime
  def roundFloor: DateTime =
    underlying.roundFloorCopy
  def roundCeiling: DateTime =
    underlying.roundCeilingCopy
  def roundDown: DateTime =
    underlying.roundFloorCopy
  def roundUp: DateTime =
    underlying.roundCeilingCopy
  def round: DateTime =
    underlying.roundHalfEvenCopy

  def apply(value: Int): DateTime = underlying.setCopy(value)
  def apply(text: String): DateTime = underlying.setCopy(text)
  def apply(text: String, locale: Locale): DateTime =
    underlying.setCopy(text, locale)
}
