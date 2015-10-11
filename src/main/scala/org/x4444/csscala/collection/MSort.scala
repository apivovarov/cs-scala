package org.x4444.csscala.collection

/**
 * Merge Sort
 */
object MSort {
  def msort[T](less: (T, T) => Boolean)(li: List[T]): List[T] = {
    def merge(a: List[T], b: List[T]): List[T] = {
      (a, b) match {
        case (_, Nil) => a
        case (Nil, _) => b
        case (x :: xx, y :: yy) => if (less(x, y)) x :: merge(xx, b) else y :: merge(a, yy)
      }
    }

    val m = li.size / 2
    if (m == 0) li
    else {
      val (li1, li2) = li.splitAt(m)
      merge(msort(less)(li1), msort(less)(li2))
    }
  }
}
