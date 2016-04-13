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
  def get(arr: Seq[Int]): Int = {
    if (arr == null || arr.length < 2) return 0

    var min = arr.head
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
    List(1,2,3)
    diff
  }

  /**
    * Recursive implementation
    *
    * @param arr - Int Array
    * @return - max diff
    */
  def getRec(arr: Seq[Int]): Int = {
    if (arr == null || arr.length < 2) return 0

    look(arr, 0, arr.head)
  }

  @tailrec
  def look(li: Seq[Int], diff: Int, min: Int): Int = {
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

  /**
    * Fold based implementation
    *
    * @param arr - Int Array
    * @return - max diff
    */
  def getFold(arr: Seq[Int]): Int = {
    if (arr == null || arr.length < 2) return 0
    // zero value (diff, min)
    val z = (0, arr.head)

    val res = arr.foldLeft(z) { case ((diff, min), a) =>
      if (a < min) (diff, a)
      else {
        val newDiff = a - min
        val diff2 = if (newDiff > diff) newDiff else diff
        (diff2, min)
      }
    }
    res._1
  }
}
