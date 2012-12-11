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

import java.util.Locale
import org.joda.time._
import org.joda.time.format.{DateTimeFormatter, DateTimeParser,
  DateTimePrinter}
import com.github.kmizu.nscala.PimpedType

class RichDateTimeFormatter(val underlying: DateTimeFormatter) extends AnyRef
  with PimpedType[DateTimeFormatter] {

  def chronology: Chronology = underlying.getChronology

  def locale: Locale = underlying.getLocale

  def parser: DateTimeParser = underlying.getParser

  def pivotYear: Int = underlying.getPivotYear.intValue

  def printer: DateTimePrinter = underlying.getPrinter

  def zone: DateTimeZone = underlying.getZone

  def parseOption(text: String): Option[DateTime] =
    try {
      Some(underlying.parseDateTime(text))
    } catch {
      case _ : UnsupportedOperationException => None
      case _ : IllegalArgumentException => None
    }
}
