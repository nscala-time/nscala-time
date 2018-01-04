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

private[time] class RichLocalDateProperty(val underlying: LocalDate.Property) extends AnyVal with PimpedType[LocalDate.Property] {

  def localDate: LocalDate    = underlying.getLocalDate
  def roundFloor: LocalDate   = underlying.roundFloorCopy
  def roundCeiling: LocalDate = underlying.roundCeilingCopy
  def roundDown: LocalDate    = underlying.roundFloorCopy
  def roundUp: LocalDate      = underlying.roundCeilingCopy
  def round: LocalDate        = underlying.roundHalfEvenCopy

  def apply(value: Int): LocalDate                   = underlying.setCopy(value)
  def apply(text: String): LocalDate                 = underlying.setCopy(text)
  def apply(text: String, locale: Locale): LocalDate = underlying.setCopy(text, locale)
}
