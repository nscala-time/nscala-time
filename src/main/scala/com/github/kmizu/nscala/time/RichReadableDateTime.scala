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

import org.joda.time._

class RichReadableDateTime(underlying: ReadableDateTime) {  
  def second: Int =
    underlying.getSecondOfMinute
  def minute: Int =
    underlying.getMinuteOfHour
  def hour: Int =
    underlying.getHourOfDay
  def day: Int =
    underlying.getDayOfMonth
  def week: Int =
    underlying.getWeekOfWeekyear
  def month: Int =
    underlying.getMonthOfYear
  def year: Int =
    underlying.getYear
  def century: Int =
    underlying.getCenturyOfEra
  
  def dateTime: DateTime =
    underlying.toDateTime
  def mutableDateTime: MutableDateTime =
    underlying.toMutableDateTime
}
