package org.x4444.csscala.zones

import org.scalatest.FunSuite

/**
  * Zones2Suite
  */
class Zones2Suite extends FunSuite {

  test("getZone1") {
    val arr = Array(
      Array(1, 1, 1, 1, 0, 1),
      Array(1, 0, 1, 1, 0, 1),
      Array(1, 0, 0, 1, 0, 1),
      Array(1, 1, 1, 1, 1, 1)
    )

    val res = new Zones2(arr).find()

    val zone1 = Set((1, 1), (2, 1), (2, 2)).map(p => Point2(p._1, p._2))

    assert(res.size == 1)
    assert(res.contains(zone1))
  }

  test("getZone2") {
    val arr = Array(
      Array(1, 1, 1, 1, 1, 1, 0, 1),
      Array(1, 1, 1, 1, 0, 1, 1, 1),
      Array(1, 0, 1, 0, 0, 0, 1, 1),
      Array(1, 1, 1, 1, 0, 1, 1, 1),
      Array(1, 1, 0, 0, 1, 1, 1, 1),
      Array(1, 1, 0, 1, 1, 1, 1, 1)
    )

    val res = new Zones2(arr).find()

    val zone1 = Set((1, 4), (2, 3), (2, 4), (2, 5), (3, 4)).map(p => Point2(p._1, p._2))
    val zone2 = Set((2, 1)).map(p => Point2(p._1, p._2))

    assert(res.size == 2)
    assert(res.contains(zone1))
    assert(res.contains(zone2))
  }
}
