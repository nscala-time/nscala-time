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
import org.joda.time.format._

object StaticDateTimeFormat extends StaticDateTimeFormat

trait StaticDateTimeFormat {
  def forPattern(pattern: String): DateTimeFormatter =
    DateTimeFormat.forPattern(pattern)
  def forStyle(style: String): DateTimeFormatter =
    DateTimeFormat.forStyle(style)
  def fullDate(): DateTimeFormatter = DateTimeFormat.fullDate()
  def fullDateTime(): DateTimeFormatter = DateTimeFormat.fullDateTime()
  def fullTime(): DateTimeFormatter = DateTimeFormat.fullTime()
  def longDate(): DateTimeFormatter = DateTimeFormat.longDate()
  def longDateTime(): DateTimeFormatter = DateTimeFormat.longDateTime()
  def longTime(): DateTimeFormatter = DateTimeFormat.longTime()
  def mediumDate(): DateTimeFormatter = DateTimeFormat.mediumDate()
  def mediumDateTime(): DateTimeFormatter = DateTimeFormat.mediumDateTime()
  def mediumTime(): DateTimeFormatter = DateTimeFormat.mediumTime()
  def patternForStyle(style: String, locale: Locale): String =
    DateTimeFormat.patternForStyle(style, locale)
  def shortDate(): DateTimeFormatter = DateTimeFormat.shortDate()
  def shortDateTime(): DateTimeFormatter = DateTimeFormat.shortDateTime()
  def shortTime(): DateTimeFormatter = DateTimeFormat.shortTime()
}
