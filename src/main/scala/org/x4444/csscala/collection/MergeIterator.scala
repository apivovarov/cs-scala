package org.x4444.csscala.collection

import scala.collection.mutable.SortedSet

/**
 * Iterator implementation which combines data from input Sorted Iterators
 * next method output is sorted
 *
 * @param iters - Sequence of Sorted Iterators
 * @tparam T - Ordering
 */
class MergeIterator[T: Ordering](iters: Seq[Iterator[T]]) extends Iterator[T] {

  type AB = (T, Iterator[T])

  implicit val abOrdering: Ordering[AB] = Ordering.by(_._1)

  val heads: SortedSet[AB] =
    iters.flatMap { x => if (x.hasNext) Some((x.next, x)) else None }.foldLeft(SortedSet.empty[AB])(_ += _)

  override def next(): T = {
    if (heads.isEmpty) {
      throw new java.util.NoSuchElementException("next on empty iterator")
    }
    val minEl = heads.min
    val (minV, iter) = minEl
    heads -= minEl
    if (iter.hasNext) {
      heads += ((iter.next, iter))
    }
    minV
  }

  override def hasNext: Boolean = !heads.isEmpty
}
