package com.github.nscala_time.time

import JodaImplicits._
import com.github.nscala_time.PimpedType
import org.joda.time._
import scala.collection.generic.CanBuildFrom

class RichInterval(val underlying: Interval) extends Super with PimpedType[Interval] {

  /** Returns a collection containing every instance between the interval, `period` time apart.
    *
    * {{{
    * scala> val start = DateTime.now
    * start: org.joda.time.DateTime = 2014-11-27T00:24:54.714+01:00
    *
    * scala> val end = start + 1.day
    * end: org.joda.time.DateTime = 2014-11-28T00:24:54.714+01:00
    *
    * scala> start to end by 1.minute
    * res0: scala.collection.immutable.IndexedSeq[org.joda.time.DateTime] = Vector(2014-11-27T00:24:54.714+01:00, ...)
    *
    * scala> val coll: Iterator[DateTime] = start to end by 1.minute
    * coll: Iterator[com.github.nscala_time.time.Imports.DateTime] = non-empty iterator
    * }}}
    */
  def by[CC[_]](period: ReadablePeriod)(implicit cbf: CanBuildFrom[Nothing, DateTime, CC[DateTime]]): CC[DateTime] = {
    val builder = cbf()

    var x = underlying.getStart

    while (x < underlying.getEnd) {
      builder += x
      x += period
    }

    builder.result
  }

}
