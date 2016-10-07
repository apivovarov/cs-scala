package org.x4444.csscala.collection

import scala.annotation.tailrec

/**
  * Flattener
  */
object Flattener {

  def flattenToIntList(l: List[Any]): List[Int] = {
    f(l, Nil, Nil).reverse
  }

  @tailrec
  private final def f(l: List[Any], res: List[Int], parent: List[List[Any]]): List[Int] = {
    l match {
      case Nil => {
        parent match {
          case Nil => res
          case (ph :: pt) => f(ph, res, pt)
        }
      }

      case (h :: t) => {
        h match {
          case v: Int => {
            f(t, v :: res, parent)
          }
          case v: List[Any] => {
            f(v, res, t :: parent)
          }
          case _ => throw new RuntimeException("Not Int or List")
        }
      }
    }
  }
}
