package com.github.nscala_time.time

import java.util.Date
import org.joda.time._

class RichDate(val underlying: Date) extends AnyVal {

  def toLocalDateTime: LocalDateTime = StaticLocalDateTime.fromDateFields(underlying)

  def toLocalDate: LocalDate = StaticLocalDate.fromDateFields(underlying)

  def toLocalTime: LocalTime = StaticLocalTime.fromDateFields(underlying)

}
