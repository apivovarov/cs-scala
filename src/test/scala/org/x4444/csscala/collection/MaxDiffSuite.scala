package org.x4444.csscala.collection

import org.scalatest.FunSuite

class MaxDiffSuite extends FunSuite {

  test("functions") {
    val f1 = MaxDiff.get(_)
    val f2 = MaxDiff.getRec(_)

    List(f1, f2).foreach { f =>
      assert(f(Array(1, 2, 3)) == 2)
      assert(f(Array(1, 2, 3, 0, 3)) == 3)
      assert(f(Array(1, 2, 3, 0, 1)) == 2)
      assert(f(Array(1, 3, 0, 1)) == 2)
      assert(f(Array(1, 3, 10, 4)) == 9)
      assert(f(Array(1, 3, 10, 4, 1)) == 9)
      assert(f(Array(1, 3, 0, 4)) == 4)
      assert(f(Array(1)) == 0)
      assert(f(Array()) == 0)
    }
  }
}
