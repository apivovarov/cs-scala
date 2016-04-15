package org.x4444.csscala.math

import org.scalatest.FunSuite

/**
  * Test Math functions
  */
class MathSuite extends FunSuite {

  test("factorial") {
    val f = Math.factorial _

    val good = List(
      (0, 1L),
      (1, 1L),
      (2, 2L),
      (3, 6L),
      (4, 24L),
      (20, 2432902008176640000L),
      (-1, -1L),
      (-2, -2L),
      (-4, -24L),
      (-20, -2432902008176640000L)
    )

    val bad = List(21, 100, -21, -100)

    good.foreach { case (x, y) =>
      assert(f(x) == y)
    }

    bad.foreach { x =>
      intercept[RuntimeException] {
        f(x)
      }
    }
  }
}
