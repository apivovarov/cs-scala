package org.x4444.csscala.clock

import java.text.SimpleDateFormat
import java.util.TimeZone

object ClockMath {

  /**
    * Each thread will have its own SimpleDateFormat instance
    */
  private val sdfTL = new ThreadLocal[SimpleDateFormat] {
    override protected def initialValue(): SimpleDateFormat = {
      val sdf = new SimpleDateFormat("HH:mm:ss.SSS")
      sdf.setTimeZone(TimeZone.getTimeZone("GMT"))
      sdf
    }
  }

  val HOUR_MS = 3600000 // ms in 1 hour
  val HOUR_12_MS = 12 * HOUR_MS // ms in 12 hours

  /**
    * Calculates angle between hands of the analog clock
    *
    * @param ms - Epoch time in ms in GMT
    * @return - angle between hands of the analog clock for the given time
    */
  def getAngleBtwHands(ms: Long): Double = {
    val minMs = ms % HOUR_MS
    val minAngle = minMs.toDouble / HOUR_MS * 360

    val hrMs = ms % HOUR_12_MS
    val hrAngle = hrMs.toDouble / HOUR_12_MS * 360

    val diff = math.abs(hrAngle - minAngle)
    if (diff > 180.0) 360 - diff else diff
  }

  /**
    * Calculates angle between hands of the analog clock
    *
    * @param isoTime - HH:mm:ss.ms
    * @return - angle between hands of the analog clock for the given time
    */
  def getAngleBtwHands(isoTime: String): Double = {
    val ms = sdfTL.get.parse(isoTime).getTime
    getAngleBtwHands(ms)
  }
}
