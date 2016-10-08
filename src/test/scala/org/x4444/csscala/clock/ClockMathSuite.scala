package org.x4444.csscala.clock

import org.scalatest.FunSuite
import org.x4444.csscala.clock.ClockMath._

/**
  * ClockMathSuite
  */
class ClockMathSuite extends FunSuite {

  test("getAngleBtwHands ms") {
    List(
      1 * HOUR_MS -> 30.0,
      2 * HOUR_MS -> 60.0,
      -2 * HOUR_MS -> 60.0,
      6 * HOUR_MS -> 180.0,
      9 * HOUR_MS -> 90.0,
      12 * HOUR_MS -> 0.0,
      11 * HOUR_MS -> 30.0,
      13 * HOUR_MS -> 30.0
    ).foreach { case (in, exp) =>
      val res = getAngleBtwHands(in)
      assert(math.abs(res - exp) <= 1E-4, s"in: $in, res: $res, exp: $exp")
    }
  }

  test("getAngleBtwHands str") {
    List(
      "01:00:00.000" -> 30.0,
      "11:00:00.000" -> 30.0,
      "13:00:00.000" -> 30.0,
      "23:00:00.000" -> 30.0,
      "12:00:00.000" -> 0.0,
      "24:00:00.000" -> 0.0,
      "02:00:00.000" -> 60.0,
      "01:05:00.000" -> 2.5,
      "01:05:27.000" -> 0.025,
      "01:05:27.272" -> 0.0,
      "07:05:27.000" -> 179.975,
      "19:05:27.000" -> 179.975,
      "10:54:33.000" -> 0.025,
      "22:54:33.000" -> 0.025,
      "04:54:33.000" -> 179.975,
      "02:27:17.000" -> 90.0583,
      "14:27:17.000" -> 90.0583,
      "19:54:33.000" -> 90.025,
      "07:54:33.000" -> 90.025
    ).foreach { case (in, exp) =>
      val res = getAngleBtwHands(in)
      assert(math.abs(res - exp) <= 1E-4, s"in: $in, res: $res, exp: $exp")
    }
  }
}
