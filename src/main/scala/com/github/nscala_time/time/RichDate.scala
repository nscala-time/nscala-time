package com.github.nscala_time.time

import java.util.Date
import org.joda.time._
import com.github.nscala_time.PimpedType

class RichDate(val underlying: Date) extends Super with PimpedType[Date] {

  def toLocalDateTime: LocalDateTime = StaticLocalDateTime.fromDateFields(underlying)

  def toLocalDate: LocalDate = StaticLocalDate.fromDateFields(underlying)

  def toLocalTime: LocalTime = StaticLocalTime.fromDateFields(underlying)

}
