package org.x4444.csscala.collection

import org.scalatest.FunSuite

class FindPairsSuite extends FunSuite {

  test("find") {
    assert(FindPairs.find(List(3, 2, 5, 1, 7, 3, 1, 3), 6) == Set((5, 1), (3, 3)))
    assert(FindPairs.find(List(3, 2, 5, 7), 6).isEmpty)
    assert(FindPairs.find(List(), 6).isEmpty)
  }

  test("findRec") {
    assert(FindPairs.findRec(List(3, 2, 5, 1, 7, 3, 1, 3), 6) == Set((5, 1), (3, 3)))
    assert(FindPairs.findRec(List(3, 2, 5, 7), 6).isEmpty)
    assert(FindPairs.findRec(List(), 6).isEmpty)
  }
}
