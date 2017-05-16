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

import org.joda.time.format.{ISODateTimeFormat => fmt, DateTimeFormatter}

object StaticISODateTimeFormat extends StaticISODateTimeFormat

trait StaticISODateTimeFormat {
  def date: DateTimeFormatter = fmt.date
  def time: DateTimeFormatter = fmt.time
  def timeNoMillis: DateTimeFormatter = fmt.timeNoMillis
  def tTime: DateTimeFormatter = fmt.tTime
  def tTimeNoMillis: DateTimeFormatter = fmt.tTimeNoMillis
  def dateTime: DateTimeFormatter = fmt.dateTime
  def dateTimeNoMillis: DateTimeFormatter = fmt.dateTimeNoMillis
  def ordinalDate: DateTimeFormatter = fmt.ordinalDate
  def ordinalDateTime: DateTimeFormatter = fmt.ordinalDateTime
  def ordinalDateTimeNoMillis: DateTimeFormatter = fmt.ordinalDateTimeNoMillis
  def weekDate: DateTimeFormatter = fmt.weekDate
  def weekDateTime: DateTimeFormatter = fmt.weekDateTime
  def weekDateTimeNoMillis: DateTimeFormatter = fmt.weekDateTimeNoMillis
  def basicDate: DateTimeFormatter = fmt.basicDate
  def basicTime: DateTimeFormatter = fmt.basicTime
  def basicTimeNoMillis: DateTimeFormatter = fmt.basicTimeNoMillis
  def basicTTime: DateTimeFormatter = fmt.basicTTime
  def basicTTimeNoMillis: DateTimeFormatter = fmt.basicTTimeNoMillis
  def basicDateTime: DateTimeFormatter = fmt.basicDateTime
  def basicDateTimeNoMillis: DateTimeFormatter = fmt.basicDateTimeNoMillis
  def basicOrdinalDate: DateTimeFormatter = fmt.basicOrdinalDate
  def basicOrdinalDateTime: DateTimeFormatter = fmt.basicOrdinalDateTime
  def basicOrdinalDateTimeNoMillis: DateTimeFormatter = fmt.basicOrdinalDateTimeNoMillis
  def basicWeekDate: DateTimeFormatter = fmt.basicWeekDate
  def basicWeekDateTime: DateTimeFormatter = fmt.basicWeekDateTime
  def basicWeekDateTimeNoMillis: DateTimeFormatter = fmt.basicWeekDateTimeNoMillis
  def year: DateTimeFormatter = fmt.year
  def yearMonth: DateTimeFormatter = fmt.yearMonth
  def yearMonthDay: DateTimeFormatter = fmt.yearMonthDay
  def weekyear: DateTimeFormatter = fmt.weekyear
  def weekyearWeek(): DateTimeFormatter = fmt.weekyearWeek
  def weekyearWeekDay(): DateTimeFormatter = fmt.weekyearWeekDay
  def hour: DateTimeFormatter = fmt.hour
  def hourMinute: DateTimeFormatter = fmt.hourMinute
  def hourMinuteSecond: DateTimeFormatter = fmt.hourMinuteSecond
  def hourMinuteSecondMillis: DateTimeFormatter = fmt.hourMinuteSecondMillis
  def hourMinuteSecondFraction: DateTimeFormatter = fmt.hourMinuteSecondFraction
  def dateHour: DateTimeFormatter = fmt.dateHour
  def dateHourMinute: DateTimeFormatter = fmt.dateHourMinute
  def dateHourMinuteSecond: DateTimeFormatter = fmt.dateHourMinuteSecond
  def dateHourMinuteSecondMillis: DateTimeFormatter = fmt.dateHourMinuteSecondMillis
  def dateHourMinuteSecondFraction: DateTimeFormatter = fmt.dateHourMinuteSecondFraction
}