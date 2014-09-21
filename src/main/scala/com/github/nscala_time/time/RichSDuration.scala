package com.github.nscala_time.time

import org.joda.time._
import com.github.nscala_time.PimpedType
import scala.concurrent.duration.{ Duration => SDuration }

class RichSDuration(val underlying: SDuration) extends Super with PimpedType[SDuration] {

  def toJodaDuration: Duration = new Duration(underlying.toMillis)

}
