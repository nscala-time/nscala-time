package com.github.nscala_time.time

import org.joda.time._
import com.github.nscala_time.PimpedType
import scala.concurrent.duration.{ Duration => SDuration }

private[time] class RichSDuration(val underlying: SDuration) extends AnyVal with PimpedType[SDuration] {

  def toJodaDuration: Duration = new Duration(underlying.toMillis)

}
