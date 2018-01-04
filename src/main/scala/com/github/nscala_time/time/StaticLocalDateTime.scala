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

import java.util.{Calendar, Date}
import org.joda.time._
import com.github.nscala_time.time.Implicits._
import org.joda.time.format.DateTimeFormatter

private[time] object StaticLocalDateTime extends StaticLocalDateTime

private[time] trait StaticLocalDateTime {
  type Property = LocalDateTime.Property
  
  def fromCalendarFields(calendar: Calendar) = LocalDateTime.fromCalendarFields(calendar)
  def fromDateFields(date: Date)             = LocalDateTime.fromDateFields(date)

  def now()                       = new LocalDateTime
  def now(zone: DateTimeZone)     = LocalDateTime.now(zone)
  def now(chronology: Chronology) = LocalDateTime.now(chronology)

  def parse(str: String) = LocalDateTime.parse(str)
  def parse(str: String, formatter: DateTimeFormatter) = LocalDateTime.parse(str, formatter)

  def nextSecond() = now + 1.second
  def nextMinute() = now + 1.minute
  def nextHour()   = now + 1.hour
  def nextDay()    = now + 1.day
  def tomorrow()   = now + 1.day
  def nextWeek()   = now + 1.week
  def nextMonth()  = now + 1.month
  def nextYear()   = now + 1.year

  def lastSecond() = now - 1.second
  def lastMinute() = now - 1.minute
  def lastHour()   = now - 1.hour
  def lastDay()    = now - 1.day
  def yesterday()  = now - 1.day
  def lastWeek()   = now - 1.week
  def lastMonth()  = now - 1.month
  def lastYear()   = now - 1.year
}
