package org.x4444.csscala.collection

import org.scalatest.FunSuite
import org.x4444.csscala.collection.MSort.msort

/**
 * Test MSort
 */
class MSortSuite extends FunSuite {

  test("msort") {
    val li1 = List(2)
    assert(msort[Int]((a, b) => a < b)(li1) == li1.sorted)
    val li2 = List(2, 1)
    assert(msort[Int]((a, b) => a < b)(li2) == li2.sorted)
    val li3 = List(2, 1, 4)
    assert(msort[Int]((a, b) => a < b)(li3) == li3.sorted)
    val li4 = List(2, 1, 4, -5)
    assert(msort[Int]((a, b) => a < b)(li4) == li4.sorted)

    val li = List(2, 1, 4, 3, 5, 1, 2, 3, 4, 5, 1, 15, 9, 4, 5, 6, 7)
    assert(msort[Int]((a, b) => a < b)(li) == li.sorted)

    assert(msort[Int]((a, b) => a > b)(li) == li.sortWith((a, b) => a > b))

    assert(msort[Int]((a, b) => a < b)(List.empty[Int]).isEmpty)
  }
}
