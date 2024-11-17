package com.github.nscala_time.time

import org.joda.time._
import scala.concurrent.duration.{ Duration => SDuration }

class RichSDuration(val underlying: SDuration) extends AnyVal {

  def toJodaDuration: Duration = new Duration(underlying.toMillis)

}
