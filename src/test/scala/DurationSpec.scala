package com.github.nscala_time.time

import com.github.nscala_time.time.Imports.{richDuration, richSDuration}
import org.joda.time.Duration
import org.scalacheck.{Prop, Arbitrary, Properties}
import scala.concurrent.duration.{Duration => SDuration}

object DurationSpec extends Properties("Duration"){

  private[this] implicit val durationArbitrary: Arbitrary[Duration] =
    Arbitrary(implicitly[Arbitrary[Int]].arbitrary.map(
      i => Duration.standardSeconds(i)
    ))

  property("toScalaDuration, toJodaDuration") =
    Prop.forAll { jodaDuration: Duration =>
      val scalaDuration: SDuration = jodaDuration.toScalaDuration
      scalaDuration.toJodaDuration == jodaDuration
    }
}
