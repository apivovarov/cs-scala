package org.x4444.csscala.zones

import org.scalatest.FunSuite

/**
  * FindZonesSuite
  */
class FindZonesSuite extends FunSuite {

  test("getZone") {
    val dic = Map(
      (0, 0) -> Point(0, 0, 1),
      (1, 0) -> Point(1, 0, 1),
      (2, 0) -> Point(2, 0, 1),
      (3, 0) -> Point(3, 0, 1),
      (4, 0) -> Point(4, 0, 0),
      (5, 0) -> Point(5, 0, 1),

      (0, 1) -> Point(0, 1, 1),
      (1, 1) -> Point(1, 1, 0),
      (2, 1) -> Point(2, 1, 1),
      (3, 1) -> Point(3, 1, 1),
      (4, 1) -> Point(4, 1, 0),
      (5, 1) -> Point(5, 1, 1),

      (0, 2) -> Point(0, 2, 1),
      (1, 2) -> Point(1, 2, 0),
      (2, 2) -> Point(2, 2, 0),
      (3, 2) -> Point(3, 2, 1),
      (4, 2) -> Point(4, 2, 0),
      (5, 2) -> Point(5, 2, 1),

      (0, 3) -> Point(0, 3, 1),
      (1, 3) -> Point(1, 3, 1),
      (2, 3) -> Point(2, 3, 1),
      (3, 3) -> Point(3, 3, 1),
      (4, 3) -> Point(4, 3, 1),
      (5, 3) -> Point(5, 3, 1)
    )

    val res = new FindZones(dic).getZones()

    val expSet = Set((4, 0), (4, 1), (4, 2))

    assert(res.size == 3)
    assert(res.toSet == expSet)
  }
}
