package com.github.nscala_time.time

import org.scalacheck.{Prop, Properties}
import org.joda.time.DateTime
import com.github.nscala_time.time.Imports._

object BasicFunctionalitySpec extends Properties("DateTime"){

  property("DateTime.now == DateTime.now") = Prop.secure {
    val now: DateTime = DateTime.now
    now == now
  }

  property("DateTime.now < (DateTime.now + 1.hours)") = Prop.secure {
    val now: DateTime = DateTime.now
    (now plusHours 1) isAfter now
  }

  property("have setters") = Prop.secure {
    val actual = DateTime.parse("2012-01-01T01:01:01.123+0900")
      .year.apply(2013) // TODO cannot call #year(2013)
      .month(3)
      .day(2)
      .hour(7)
      .minute(8)
      .second(9)
    val expected = DateTime.parse("2013-03-02T07:08:09.123+0900")
    actual == expected
  }

  property("have setters using millis") = Prop.secure {
    val actual = DateTime.parse("2012-01-01T01:01:01.123+0900")
      .year.apply(2013) // TODO cannot call #year(2013)
      .month(3)
      .day(2)
      .hour(7)
      .minute(8)
      .second(9)
      .millis(500)
    val expected = DateTime.parse("2013-03-02T07:08:09.500+0900")
    actual == expected
  }

}
