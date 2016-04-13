package org.x4444.csscala.string

import scala.annotation.tailrec

/**
  * Returns min Window(start, end) of String I containing all chars from Set T
  */
object MinSubstr {
  def getMinSubstr(I: String, T: Set[Char]): Option[(Int, Int)] = {
    def sz(x: (Int, Int)) = x._2 - x._1
    if (T.isEmpty) return None
    I.zipWithIndex.flatMap { case (a, i) =>
      if (T.contains(a)) {
        getCandidate(i, i, I, T)
      } else {
        None
      }
    }.reduceOption((a, b) => if (sz(a) <= sz(b)) a else b)
  }

  @tailrec
  def getCandidate(start: Int, end: Int, I: String, T: Set[Char]): Option[(Int, Int)] = {
    if (T.isEmpty) Some((start, end - 1))
    else if (end >= I.length) None
    else getCandidate(start, end + 1, I, T - I(end))
  }
}
