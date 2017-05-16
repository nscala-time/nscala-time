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
package com.github.nscala_time.time

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
  type YearMonth      = org.joda.time.YearMonth
  type MonthDay       = org.joda.time.MonthDay
}

trait StaticForwarderImports {
  val DateTime          = com.github.nscala_time.time.StaticDateTime
  val DateTimeFormat    = com.github.nscala_time.time.StaticDateTimeFormat
  val ISODateTimeFormat = com.github.nscala_time.time.StaticISODateTimeFormat
  val DateTimeZone      = com.github.nscala_time.time.StaticDateTimeZone
  val Duration          = com.github.nscala_time.time.StaticDuration
  val Interval          = com.github.nscala_time.time.StaticInterval
  val LocalDate         = com.github.nscala_time.time.StaticLocalDate
  val LocalDateTime     = com.github.nscala_time.time.StaticLocalDateTime
  val LocalTime         = com.github.nscala_time.time.StaticLocalTime
  val Period            = com.github.nscala_time.time.StaticPeriod
  val Partial           = com.github.nscala_time.time.StaticPartial
  val YearMonth         = com.github.nscala_time.time.StaticYearMonth
  val MonthDay          = com.github.nscala_time.time.StaticMonthDay
}
