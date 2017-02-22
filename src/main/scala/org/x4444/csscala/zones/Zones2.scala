package org.x4444.csscala.zones

import scala.annotation.tailrec

/**
  * Find Zeros surrounded by Ones
  *
  * 1 1 1 1 0 1
  * 1 0 1 1 0 1
  * 1 0 0 1 0 1
  * 1 1 1 1 1 1
  */
class Zones2(arr: Array[Array[Int]]) {

  val h = arr.length
  assert(h > 0)
  val w = arr(0).length
  assert(w > 0)

  def isTouchingEdge(points: Set[Point2]): Boolean = {
    points.exists(p => p.r == 0 || p.c == 0 || p.r == h - 1 || p.c == w - 1)
  }

  def getNeib(p: Point2): Set[Point2] = {
    val t = if (p.r > 0) Some(Point2(p.r - 1, p.c)) else None
    val b = if (p.r < h - 1) Some(Point2(p.r + 1, p.c)) else None
    val l = if (p.c > 0) Some(Point2(p.r, p.c - 1)) else None
    val r = if (p.c < w - 1) Some(Point2(p.r, p.c + 1)) else None
    Set(t, b, l, r).flatten
  }

  def findZone(p: Point2): Set[Point2] = {
    @tailrec
    def findZoneInternal(plan: Set[Point2], zoneRes: Set[Point2]): Set[Point2] = {
      val newPlan = plan.flatMap(getNeib).filter(p => arr(p.r)(p.c) == 0) -- zoneRes
      if (newPlan.isEmpty) zoneRes
      else findZoneInternal(newPlan, newPlan ++ zoneRes)
    }

    findZoneInternal(Set(p), Set(p))
  }

  def find(): List[Set[Point2]] = {
    val zeros = (for (
      r <- 0 until h;
      c <- 0 until w
      if arr(r)(c) == 0
    ) yield Point2(r, c)).toList

    @tailrec
    def ff3(doneZeros: Set[Point2], zeros: List[Point2], res: List[Set[Point2]]): List[Set[Point2]] = {
      zeros match {
        case Nil => res
        case p :: t => {
          if (doneZeros.contains(p)) {
            ff3(doneZeros, t, res)
          } else {
            val zone = findZone(p)
            val doneZeros2 = zone ++ doneZeros
            val res2 = if (isTouchingEdge(zone)) res else zone :: res
            ff3(doneZeros2, t, res2)
          }
        }
      }
    }

    ff3(Set.empty[Point2], zeros, Nil)
  }
}

case class Point2(r: Int, c: Int)
