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

class RichString(val s: String) extends Super {

  def toDateTime(format: String)        = dateTimeFormat(format)
  def toDateTime                        = new DateTime(s)
  def toInterval                        = new Interval(s)
  def toLocalDate(format: String)       = localDateTimeFormat(format)
  def toLocalDate                       = new LocalDate(s)
  def toDateTimeOption(format: String)  = toDateOption(toDateTime(format))
  def toDateTimeOption                  = toDateOption(toDateTime)
  def toLocalDateOption(format: String) = toDateOption(toLocalDate(format))
  def toLocalDateOption                 = toDateOption(toLocalDate)

  def toDateOption[A](f: => A): Option[A] = try {
    Some(f)
  } catch {
    case e: IllegalArgumentException => None
  }

  def toIntervalOption = try {
    Some(toInterval)
  } catch {
    case e: IllegalArgumentException => None
  }

  def dateTimeFormat(format: String)      = DateTimeFormat.forPattern(format).parseDateTime(s)
  def localDateTimeFormat(format: String) = DateTimeFormat.forPattern(format).parseLocalDate(s)
}