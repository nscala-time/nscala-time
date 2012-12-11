package com.github.kmizu.nscala.time

import java.util.Date
import org.joda.time._
import com.github.kmizu.nscala.PimpedType

class RichDate(val underlying: Date) extends AnyRef with PimpedType[Date] {

  def toLocalDateTime: LocalDateTime = StaticLocalDateTime.fromDateFields(underlying)

  def toLocalDate: LocalDate = StaticLocalDate.fromDateFields(underlying)

  def toLocalTime: LocalTime = StaticLocalTime.fromDateFields(underlying)

}
