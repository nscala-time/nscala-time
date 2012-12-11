package com.github.kmizu.nscala.time

import org.specs2.mutable.Specification
import com.github.kmizu.nscala.time.Imports._
import org.joda.time.DateTime

/**
 * @author Kota Mizushima
 * Date: 2012/12/11
 * Time: 0:40
 */
class BasicFunctionalitySpec extends Specification {

  "DateTime.now" should {
    val now = DateTime.now
    "== DateTime.now" in {
      now must ===(now)
    }
    "< DateTime.now + 1.hours" in {
      (now plusHours 1).isAfterNow must ===(true)
    }
  }

}
