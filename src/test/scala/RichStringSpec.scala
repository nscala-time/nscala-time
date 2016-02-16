package com.github.nscala_time.time

import com.github.nscala_time.time.Imports._
import org.scalacheck.{Prop, Properties}

object RichStringSpec extends Properties("RichString"){

  property("String to DateTime") = Prop.secure {
    "2012-08-08".toDateTime == new DateTime("2012-08-08")
  }

  property("String to DateTime") = Prop.secure {
    "12-08-08".toDateTime("yy-MM-dd") == new DateTime("2012-08-08")
  }

  property(""" "2012-08-08" should yield Some[DateTime] """) = Prop.secure {
    "2012-08-08".toDateTimeOption == Some(new DateTime("2012-08-08"))
  }

  property(""" "2012-08-08" should yield Some[DateTime] """) = Prop.secure {
    "12-08-08".toDateTimeOption("yy-MM-dd") == Some(new DateTime("2012-08-08"))
  }

  property(""" "" yield None """) = Prop.secure {
    "".toDateTimeOption == None
  }

  property(""" "2012-08-08" should parse""") = Prop.secure {
    "2012-08-08".toLocalDate == new LocalDate("2012-08-08")
  }

  property(""" "2012-08-08" should parse""") = Prop.secure {
    "12-08-08".toLocalDate("yy-MM-dd") == new LocalDate("2012-08-08")
  }

  property(""" "2012-08-08" should yield Some[LocalDate] """) = Prop.secure {
    "2012-08-08".toLocalDateOption == Some(new LocalDate("2012-08-08"))
  }

  property(""" "2012-08-08" should yield Some[LocalDate] """) = Prop.secure {
    "12-08-08".toLocalDateOption("yy-MM-dd") == Some(new LocalDate("2012-08-08"))
  }

  property(""" "" should yield None """) = Prop.secure {
    "".toLocalDateOption == None
  }
}
