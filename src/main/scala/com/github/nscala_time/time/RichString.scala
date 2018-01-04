/**
 * Copyright 2012 Christian Krause
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

import org.joda.time.format.DateTimeFormat

private[time] class RichString(val s: String) extends AnyVal {
  def toDateTime                        = new DateTime(s)
  def toInterval                        = new Interval(s)
  def toLocalDate                       = new LocalDate(s)
  def toDateTimeOption                  = toOption(toDateTime)
  def toLocalDateOption                 = toOption(toLocalDate)
  def toIntervalOption                  = toOption(toInterval)
  def toDateTime(format: String)        = dateTimeFormat(format)
  def toLocalDate(format: String)       = localDateTimeFormat(format)
  def toDateTimeOption(format: String)  = toOption(toDateTime(format))
  def toLocalDateOption(format: String) = toOption(toLocalDate(format))

  private def toOption[A](f: => A): Option[A] = try {
    Some(f)
  } catch {
    case _: IllegalArgumentException => None
  }

  def dateTimeFormat(format: String)      = DateTimeFormat.forPattern(format).parseDateTime(s)
  def localDateTimeFormat(format: String) = DateTimeFormat.forPattern(format).parseLocalDate(s)
}
