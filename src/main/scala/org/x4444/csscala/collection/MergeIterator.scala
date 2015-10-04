package org.x4444.csscala.collection

import scala.collection.mutable.SortedSet

/**
 * Iterator implementation which combines and sorts data from several sorted Iterators
 *
 * @param iters - Sequence of Sorted Iterators
 * @tparam T - Ordering
 */
class MergeIterator[T: Ordering](iters: Seq[Iterator[T]]) extends Iterator[T] {

  type KV = (T, Iterator[T])

  implicit val kvOrdering: Ordering[KV] = Ordering.by(_._1)

  val heads: SortedSet[KV] =
    iters.flatMap(iter => if (iter.hasNext) Some((iter.next, iter)) else None).foldLeft(SortedSet.empty[KV])(_ += _)

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

object MergeIterator {
  def empty[T: Ordering]: Iterator[T] = MergeIterator(Seq.empty[Iterator[T]])

  def apply[T: Ordering](iters: Seq[Iterator[T]]): scala.collection.Iterator[T] = new MergeIterator[T](iters)
}
