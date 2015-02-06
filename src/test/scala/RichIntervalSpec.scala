package com.github.nscala_time.time

import org.scalacheck._
import org.scalacheck.Prop._

object RichIntervalSpec extends Properties("RichInterval") with Imports {

  property("by") = forAll(Gen.choose(1,1440)) { n =>
    val start = DateTime.now
    val end = start + 1.day

    val coll = start to end by n.minute

    coll forall { date =>
      start <= date &&
      date <= end
    }
  }

  property("by, coll.last == interval.end") = forAll(Gen.choose(1,1440)) { n =>
    val start = DateTime.now
    val end = start + n.minute

    val coll = start to end by 1.minute

    coll.last == end
  }

}
