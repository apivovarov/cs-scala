package org.x4444.csscala.zones

import scala.annotation.tailrec

// Find Zeros surrounded by Ones

// 1 1 1 1 0 1
// 1 0 1 1 0 1
// 1 0 0 1 0 1
// 1 1 1 1 1 1

case class Point(x: Int, y: Int, var v: Int)

class FindZones(val dic: Map[(Int, Int), Point]) {

  val maxX = 5
  val maxY = 3

  def getZones(): List[(Int, Int)] = {
    val allZeros = dic.values.filter(_.v == 0)

    val res = ff(allZeros.toList, Nil, Set.empty[Point])
    val zerosToConvert = res.filter(isTouchingEdge)

    zerosToConvert.flatMap(identity).map(p => (p.x, p.y))
  }

  def getNeighbours(p: Point): Set[Point] = {
    val u: Option[Point] = dic.get((p.x, p.y - 1))
    val l: Option[Point] = dic.get((p.x - 1, p.y))
    val d: Option[Point] = dic.get((p.x, p.y + 1))
    val r: Option[Point] = dic.get((p.x + 1, p.y))

    Set(u, l, d, r).flatten
  }

  def getNeighbours(pp: Set[Point]): Set[Point] = {
    pp.flatMap(getNeighbours)
  }

  def isTouchingEdge(points: Set[Point]): Boolean = {
    points.exists(p => p.x == 0 || p.x == maxX || p.y == 0 || p.y == maxY)
  }

  @tailrec
  final def f(p: Set[Point], zeros: Set[Point]): Set[Point] = {
    val newZeros = getNeighbours(p).filter(_.v == 0) -- zeros
    if (newZeros.isEmpty) {
      zeros
    } else {
      val combZeros = newZeros ++ zeros
      f(newZeros, combZeros)
    }
  }

  @tailrec
  final def ff(zeros: List[Point], res: List[Set[Point]], visited: Set[Point]): List[Set[Point]] = {
    zeros match {
      case Nil => res
      case (p :: t) => {
        if (visited.contains(p)) {
          ff(t, res, visited)
        } else {
          val r0 = f(Set(p), Set(p))
          val res2 = r0 :: res
          val vis2 = visited ++ r0
          ff(t, res2, vis2)
        }
      }
    }
  }
}
