package com.github.nscala_time.time

import JodaImplicits._
import com.github.nscala_time.PimpedType
import org.joda.time._

class RichInterval(val underlying: Interval) extends AnyVal with PimpedType[Interval] {

  /** Returns a collection containing every instance between the interval, `period` time apart.
    *
    * {{{
    * scala> val start = DateTime.now()
    * start: org.joda.time.DateTime = 2014-11-27T00:24:54.714+01:00
    *
    * scala> val end = start + 1.day
    * end: org.joda.time.DateTime = 2014-11-28T00:24:54.714+01:00
    *
    * scala> start to end by 1.minute
    * res0: scala.collection.immutable.List[org.joda.time.DateTime] = List(2014-11-27T00:24:54.714+01:00, ...)
    *
    * }}}
    */
  def by(period: ReadablePeriod): List[DateTime] = {
    val builder = List.newBuilder[DateTime]

    var x = underlying.getStart

    while (x <= underlying.getEnd) {
      builder += x
      x += period
    }

    builder.result
  }

}
