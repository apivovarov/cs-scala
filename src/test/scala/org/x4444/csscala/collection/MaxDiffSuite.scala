package org.x4444.csscala.collection

import org.scalatest.FunSuite

class MaxDiffSuite extends FunSuite {

  test("functions") {
    val inOut = Seq(
      (Seq(1, 2, 3), 2),
      (Seq(1, 2, 3, 0, 3), 3),
      (Seq(1, 2, 3, 0, 1), 2),
      (Seq(1, 3, 0, 1), 2),
      (Seq(1, 3, 10, 4), 9),
      (Seq(1, 3, 10, 4, 1), 9),
      (Seq(1, 3, 0, 4), 4),
      (Seq(1), 0),
      (Seq(1), 0)
    )

    inOut.foreach { x =>
      assert(MaxDiff.get(x._1) == x._2)
      assert(MaxDiff.getRec(x._1) == x._2)
      assert(MaxDiff.getFold(x._1) == x._2)
    }
  }
}
