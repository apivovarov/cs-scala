package org.x4444.csscala.collection

import scala.annotation.tailrec

/**
  * For a given integer list, find all pairs that sum up to given constant.
  * ex. [3 2 5 1 7 3 1 3] and 6, then answer should be 5, 1), (3, 3)
  */
object FindPairs {

  /**
    * Dictionary based implementation
    * @param li - list of integers
    * @param c - constant
    * @return Pairs
    */
  def find(li: List[Int], c: Int): Iterable[(Int, Int)] = {
    val liIdx = li.zipWithIndex

    val nums = liIdx.groupBy(_._1)

    liIdx.flatMap { case (v, idx) =>
      val v2 = c - v
      nums.get(v2).toList.flatMap(ids => ids.filter(_._2 != idx)).
        map { case (v2, idx2) => if (v > v2) (v, v2) else (v2, v) }
    }.toSet
  }

  /**
    * Recursive implementation
    * @param li - list of integers
    * @param c - constant
    * @return Pairs
    */
  def findRec(li: List[Int], c: Int): Iterable[(Int, Int)] = {
    val arr = li.sorted.toArray

    def pair(a: Int, b: Int): (Int, Int) = if (a < b) (b, a) else (a, b)

    @tailrec
    def getPairs(min: Int, max: Int, pairs: List[(Int, Int)]): List[(Int, Int)] = {
      if (min >= max) pairs
      else {
        val s = arr(min) + arr(max)
        if (s > c) getPairs(min, max - 1, pairs)
        else if (s < c) getPairs(min + 1, max, pairs)
        else getPairs(min + 1, max, pair(arr(min), arr(max)) :: pairs)
      }
    }

    getPairs(0, arr.length - 1, Nil).toSet
  }
}
