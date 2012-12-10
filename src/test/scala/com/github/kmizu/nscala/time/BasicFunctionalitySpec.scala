package com.github.kmizu.nscala.time

import org.specs2.mutable.Specification
import Implicits._
import org.joda.time.DateTime

/**
 * @author Kota Mizushima
 * Date: 2012/12/11
 * Time: 0:40
 */
class BasicFunctionalitySpec extends Specification {
  "DateTime.now" should {
    "== DateTime.now" in {
      val now = DateTime.now
      now must ===(now)
    }
  }

}
