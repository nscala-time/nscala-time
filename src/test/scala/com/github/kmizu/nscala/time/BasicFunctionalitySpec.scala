package com.github.kmizu.nscala.time

import org.specs2.mutable.Specification
import org.joda.time.DateTime
import Imports._

/**
 * @author Kota Mizushima
 * Date: 2012/12/11
 * Time: 0:40
 */
class BasicFunctionalitySpec extends Specification {

  "DateTime.now" should {
    val now: DateTime = DateTime.now
    "== DateTime.nw" in {
      now must ===(now)
    }
    "< DateTime.now + 1.hours" in {
      (now plusHours 1) isAfter now must ===(true)
    }
  }

}
