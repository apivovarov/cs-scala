package org.x4444.csscala.collection

/**
  * Calculates max diff for array. diff conditions: i < j and a[i] < a[j]
  */
object MaxDiff {

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
}
