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

import java.util.Locale
import org.joda.time._
import com.github.nscala_time.PimpedType

class RichLocalTimeProperty(val underlying: LocalTime.Property) extends AnyRef with PimpedType[LocalTime.Property] {

  def localTime: LocalTime = underlying.getLocalTime

  def roundFloor: LocalTime = underlying.roundFloorCopy

  def roundCeiling: LocalTime = underlying.roundCeilingCopy

  def roundDown: LocalTime = underlying.roundFloorCopy

  def roundUp: LocalTime = underlying.roundCeilingCopy

  def round: LocalTime = underlying.roundHalfEvenCopy

  def apply(value: Int): LocalTime = underlying.setCopy(value)

  def apply(text: String): LocalTime = underlying.setCopy(text)

  def apply(text: String, locale: Locale): LocalTime = underlying.setCopy(text, locale)

}
