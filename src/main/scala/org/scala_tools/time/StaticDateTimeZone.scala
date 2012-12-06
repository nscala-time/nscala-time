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

import org.joda.time._

object StaticDateTimeZone extends StaticDateTimeZone

trait StaticDateTimeZone {
  lazy val UTC = DateTimeZone.UTC
  def forID(id: String) = DateTimeZone.forID(id)
  def forOffsetHours(hours: Int) = DateTimeZone.forOffsetHours(hours)
  def forOffsetHoursMinutes(hours: Int, minutes: Int) =
    DateTimeZone.forOffsetHoursMinutes(hours, minutes)
  def forOffsetMillis(millis: Int) = DateTimeZone.forOffsetMillis(millis)
  def forTimeZone(zone: java.util.TimeZone) = DateTimeZone.forTimeZone(zone)
  def getAvailableIDs() = DateTimeZone.getAvailableIDs()
  def getDefault() = DateTimeZone.getDefault()
  def getNameProvider() = DateTimeZone.getNameProvider()
  def getProvider() = DateTimeZone.getProvider()
  def setDefault(zone: DateTimeZone) = DateTimeZone.setDefault(zone)
  def setNameProvider(nameProvider: tz.NameProvider) =
    DateTimeZone.setNameProvider(nameProvider)
  def setProvider(provider: tz.Provider) = DateTimeZone.setProvider(provider)
}
