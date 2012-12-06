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

import java.util.Locale
import org.joda.time._
import org.joda.time.field.AbstractReadableInstantFieldProperty

class RichAbstractReadableInstantFieldProperty(underlying: AbstractReadableInstantFieldProperty) {
  def shortText: String =
    underlying.getAsShortText
  def asShortText: String =
    underlying.getAsShortText
  def shortText(locale: Locale): String =
    underlying.getAsShortText(locale)
  def asShortText(locale: Locale): String =
    underlying.getAsShortText(locale)
  def asString: String =
    underlying.getAsString
  def text: String =
    underlying.getAsText
  def asText: String =
    underlying.getAsText
  def text(locale: Locale): String =
    underlying.getAsText(locale)
  def asText(locale: Locale): String =
    underlying.getAsText(locale)
  def durationField: DurationField =
    underlying.getDurationField
  def field: DateTimeField =
    underlying.getField
  def fieldType: DateTimeFieldType =
    underlying.getFieldType
  def leapAmount: Int =
    underlying.getLeapAmount
  def leapDurationField: DurationField =
    underlying.getLeapDurationField
  def maximumValue: Int =
    underlying.getMaximumValue
  def maxValue: Int =
    underlying.getMaximumValue
  def maximumValueOverall: Int =
    underlying.getMaximumValueOverall
  def maxValueOverall: Int =
    underlying.getMaximumValueOverall
  def minimumValue: Int =
    underlying.getMinimumValue
  def minValue: Int =
    underlying.getMinimumValue
  def minimumValueOverall: Int =
    underlying.getMinimumValueOverall
  def minValueOverall: Int =
    underlying.getMinimumValueOverall
  def name: String =
    underlying.getName
  def rangeDurationField: DurationField =
    underlying.getRangeDurationField

  def interval: Interval =
    underlying.toInterval
}
