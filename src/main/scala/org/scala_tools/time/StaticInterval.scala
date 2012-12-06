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

import org.scala_tools.time.Implicits._
import org.joda.time._

object StaticInterval extends StaticInterval

trait StaticInterval {
  def thisSecond = StaticDateTime.now.second.interval
  def thisMinute = StaticDateTime.now.minute.interval
  def thisHour   = StaticDateTime.now.hour.interval
  def thisDay    = StaticDateTime.now.day.interval
  def today      = StaticDateTime.now.day.interval
  def thisWeek   = StaticDateTime.now.week.interval
  def thisMonth  = StaticDateTime.now.month.interval
  def thisYear   = StaticDateTime.now.year.interval

  def nextSecond = StaticDateTime.nextSecond.second.interval
  def nextMinute = StaticDateTime.nextMinute.minute.interval
  def nextHour   = StaticDateTime.nextHour.hour.interval
  def nextDay    = StaticDateTime.nextDay.day.interval
  def tomorrow   = StaticDateTime.nextDay.day.interval
  def nextWeek   = StaticDateTime.nextWeek.week.interval
  def nextMonth  = StaticDateTime.nextMonth.month.interval
  def nextYear   = StaticDateTime.nextYear.year.interval

  def lastSecond = StaticDateTime.lastSecond.second.interval
  def lastMinute = StaticDateTime.lastMinute.minute.interval
  def lastHour   = StaticDateTime.lastHour.hour.interval
  def lastDay    = StaticDateTime.lastDay.day.interval
  def yesterday  = StaticDateTime.lastDay.day.interval
  def lastWeek   = StaticDateTime.lastWeek.week.interval
  def lastMonth  = StaticDateTime.lastMonth.month.interval
  def lastYear   = StaticDateTime.lastYear.year.interval
}
