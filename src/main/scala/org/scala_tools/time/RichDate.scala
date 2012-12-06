package org.scala_tools.time

import java.util.Date
import org.joda.time._

class RichDate(val d: Date) {
  def toLocalDateTime: LocalDateTime = StaticLocalDateTime.fromDateFields(d)
  def toLocalDate: LocalDate = StaticLocalDate.fromDateFields(d)
  def toLocalTime: LocalTime = StaticLocalTime.fromDateFields(d)
}
