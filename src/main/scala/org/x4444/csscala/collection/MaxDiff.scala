package org.x4444.csscala.collection

import scala.annotation.tailrec

/**
  * Calculates max diff for array. diff conditions: i < j and a[i] < a[j]
  */
object MaxDiff {

  /**
    * Regular implementation
    *
    * @param arr - Int Array
    * @return - max diff
    */
  def get(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 2) return 0

    var min = arr(0)
    var diff = 0

    for (a <- arr) {
      if (a < min) {
        min = a
      } else {
        val newDiff = a - min
        if (newDiff > diff) {
          diff = newDiff
        }
      }
    }
    diff
  }

  /**
    * Recursive implementation
    *
    * @param arr - Int Array
    * @return - max diff
    */
  def getRec(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 2) return 0

    look(arr.toList, 0, arr(0))
  }

  @tailrec
  def look(li: List[Int], diff: Int, min: Int): Int = {
    li match {
      case Nil => diff
      case x :: tail => {
        if (x < min) look(tail, diff, x)
        else {
          val newDiff = x - min
          val diff2 = if (newDiff > diff) newDiff else diff
          look(tail, diff2, min)
        }
      }
    }
  }
}
