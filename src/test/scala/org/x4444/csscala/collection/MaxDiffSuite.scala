package org.x4444.csscala.collection

import org.scalatest.FunSuite

class MaxDiffSuite extends FunSuite {

  test("get") {
    assert(MaxDiff.get(Array(1, 2, 3)) == 2)

    assert(MaxDiff.get(Array(1, 2, 3, 0, 3)) == 3)

    assert(MaxDiff.get(Array(1, 2, 3, 0, 1)) == 2)

    assert(MaxDiff.get(Array(1, 3, 0, 1)) == 2)

    assert(MaxDiff.get(Array(1, 3, 10, 4)) == 9)
    
    assert(MaxDiff.get(Array(1, 3, 10, 4, 1)) == 9)

    assert(MaxDiff.get(Array(1, 3, 0, 4)) == 4)

    assert(MaxDiff.get(Array(1)) == 0)

    assert(MaxDiff.get(Array()) == 0)
  }
}
