/**
 * Copyright 2009 Jorge Ortiz
 * Copyright 2009 Barry Kaplan
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

object Imports extends Imports
object TypeImports extends TypeImports
object StaticForwarderImports extends StaticForwarderImports

trait Imports extends TypeImports with StaticForwarderImports with Implicits

trait TypeImports {
  type Chronology     = org.joda.time.Chronology
  type DateTime       = org.joda.time.DateTime
  type DateTimeFormat = org.joda.time.format.DateTimeFormat
  type DateTimeZone   = org.joda.time.DateTimeZone
  type Duration       = org.joda.time.Duration
  type Interval       = org.joda.time.Interval
  type LocalDate      = org.joda.time.LocalDate
  type LocalDateTime  = org.joda.time.LocalDateTime
  type LocalTime      = org.joda.time.LocalTime
  type Period         = org.joda.time.Period
  type Partial        = org.joda.time.Partial
}

trait StaticForwarderImports {
  val DateTime       = org.scala_tools.time.StaticDateTime
  val DateTimeFormat = org.scala_tools.time.StaticDateTimeFormat
  val DateTimeZone   = org.scala_tools.time.StaticDateTimeZone
  val Duration       = org.scala_tools.time.StaticDuration
  val Interval       = org.scala_tools.time.StaticInterval
  val LocalDate      = org.scala_tools.time.StaticLocalDate
  val LocalDateTime  = org.scala_tools.time.StaticLocalDateTime
  val LocalTime      = org.scala_tools.time.StaticLocalTime
  val Period         = org.scala_tools.time.StaticPeriod
  val Partial        = org.scala_tools.time.StaticPartial
}
