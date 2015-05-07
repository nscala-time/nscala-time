package com.github.nscala_time.time

import com.github.nscala_time.time.Imports._
import org.scalacheck.{Prop, Properties}

object OrderingSpec extends Properties("Ordering"){

  property("DateTime") = Prop.secure {
    val now = DateTime.now
    val l = List(now.second(0), now.second(3), now.second(10), now.second(1))
    assert(l.sorted == List(now.second(0), now.second(1), now.second(3), now.second(10)))
    l.max == now.second(10)
  }

  property("LocalDate") = Prop.secure {
    val today = LocalDate.now
    val l = List(today.day(1), today.day(3), today.day(10), today.day(2))
    assert(l.sorted == List(today.day(1), today.day(2), today.day(3), today.day(10)))
    l.max == today.day(10)
  }

  property("Days") = Prop.secure {
    import org.joda.time.Days._
    val l = List(ZERO, TWO, FIVE, THREE)
    assert(l.sorted == List(ZERO, TWO, THREE, FIVE))
    l.max == FIVE
  }

  property("Duration") = Prop.secure {
    val l = List(1.second, 5.seconds, 2.seconds, 4.seconds).map(_.toDuration)
    assert(l.sorted == List(1.second, 2.seconds, 4.seconds, 5.seconds).map(_.toDuration))
    l.max == 5.seconds.toDuration
  }

}
