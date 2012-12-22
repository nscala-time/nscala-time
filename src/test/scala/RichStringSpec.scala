package com.github.nscala_time.time

import org.specs2._

class RichStringSpec extends Specification with TypeImports with StringImplicits { def is =

  // -----------------------------------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------------------------------

  "String to DateTime"                                                                             ^
    """"2012-08-08" should parse"""                                             ! a1               ^
                                                                                                  p^
  "String to Option[DateTime]"                                                                     ^
    """"2012-08-08" should yield Some[DateTime]"""                              ! b1               ^
    """"" should yield None"""                                                  ! b2               ^
                                                                                                  p^
  "String to LocalDate"                                                                            ^
    """"2012-08-08" should parse"""                                             ! c1               ^
                                                                                                  p^
  "String to Option[LocalDate]"                                                                    ^
    """"2012-08-08" should yield Some[LocalDate]"""                             ! d1               ^
    """"" should yield None"""                                                  ! d2               ^
                                                                                                 end
  // -----------------------------------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------------------------------

  def a1 = "2012-08-08".toDateTime === new DateTime("2012-08-08")

  def b1 = "2012-08-08".toDateTimeOption must beSome(new DateTime("2012-08-08"))
  def b2 = "".toDateTimeOption must beNone

  def c1 = "2012-08-08".toLocalDate === new LocalDate("2012-08-08")

  def d1 = "2012-08-08".toLocalDateOption must beSome(new LocalDate("2012-08-08"))
  def d2 = "".toLocalDateOption must beNone

}
