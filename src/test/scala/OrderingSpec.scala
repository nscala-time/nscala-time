import org.specs2.mutable.Specification

import com.github.nscala_time.time.Imports._

class OrderingSpec extends Specification {

  "DateTime" should {
    "be able to sort" in {
      val now = DateTime.now
      val l = List(now.second(0), now.second(3), now.second(10), now.second(1))
      l.sorted must equalTo(List(now.second(0), now.second(1), now.second(3), now.second(10)))
      l.max must equalTo(now.second(10))
    }
  }

  "LocalDate" should {
    "be able to sort" in {
      val today = LocalDate.now
      val l = List(today.day(1), today.day(3), today.day(10), today.day(2))
      l.sorted must equalTo(List(today.day(1), today.day(2), today.day(3), today.day(10)))
      l.max must equalTo(today.day(10))
    }
  }

  "Days" should {
    "be able to sort" in {
      import org.joda.time.Days._
      val l = List(ZERO, TWO, FIVE, THREE)
      l.sorted must equalTo(List(ZERO, TWO, THREE, FIVE))
      l.max must equalTo(FIVE)
    }
  }

  "Duration" should {
    "be able to sort" in {
      val l = List(1.second, 5.seconds, 2.seconds, 4.seconds).map(_.toDuration)
      l.sorted must equalTo(List(1.second, 2.seconds, 4.seconds, 5.seconds).map(_.toDuration))
      l.max must equalTo(5.seconds.toDuration)
    }
  }

  override def intToRichLong(i: Int) = null
}
