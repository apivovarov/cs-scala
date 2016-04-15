package org.x4444.csscala.math

import scala.annotation.tailrec

/**
  * Common Math functions
  */
object Math {

  /**
    * Calculates factorial, 20! is a max
    */
  def factorial(n: Int): Long = {
    @tailrec
    def factInt(n: Int, acc: Long): Long = {
      if (n == 1) acc
      else factInt(n - 1, acc * n)
    }
    if (n > 20 || n < -20) throw new RuntimeException("n should be in [-20:20] range")
    else if (n == 0) 1
    else if (n > 0) factInt(n, 1L)
    else -factInt(-n, 1L)
  }
}
