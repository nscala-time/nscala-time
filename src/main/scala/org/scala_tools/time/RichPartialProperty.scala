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

class RichPartialProperty(underlying: Partial.Property) {
  def partial: Partial =
    underlying.getPartial

  def apply(value: Int): Partial = underlying.setCopy(value)
  def apply(text: String): Partial = underlying.setCopy(text)
  def apply(text: String, locale: Locale): Partial =
    underlying.setCopy(text, locale)
}
