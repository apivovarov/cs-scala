package org.x4444.csscala.collection

import org.scalatest.FunSuite

class MaxDiffSuite extends FunSuite {

  test("functions") {
    val inOut = List(
      (Array(1, 2, 3), 2),
      (Array(1, 2, 3, 0, 3), 3),
      (Array(1, 2, 3, 0, 1), 2),
      (Array(1, 3, 0, 1), 2),
      (Array(1, 3, 10, 4), 9),
      (Array(1, 3, 10, 4, 1), 9),
      (Array(1, 3, 0, 4), 4),
      (Array(1), 0),
      (Array(1), 0)
    )

    inOut.foreach { x =>
      assert(MaxDiff.get(x._1) == x._2)
      assert(MaxDiff.getRec(x._1) == x._2)
    }
  }
}
