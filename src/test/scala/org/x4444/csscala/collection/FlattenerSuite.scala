package org.x4444.csscala.collection

import org.scalatest.FunSuite

/**
  * FlattenerSuite
  */
class FlattenerSuite extends FunSuite {
  test("flattenToIntList") {
    val res = Flattener.flattenToIntList(List(1, 2, List(3, List(4, 5), 6, List(7, 8)), 9))
    val expRes = 1 to 9
    assert(res == expRes)
  }
}
