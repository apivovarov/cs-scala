package org.x4444.csscala.collection

import org.scalatest.FunSuite

class MergeIteratorSuite extends FunSuite {

  def getIter: Iterator[Int] = MergeIterator(Seq(Iterator(1, 5, 8), Iterator(2, 4, 9)))

  test("MergeIterator") {
    val iter = getIter
    assert(iter.hasNext)
    assert(iter.toList === List(1, 2, 4, 5, 8, 9))
    assert(!iter.hasNext)

    val iter2 = getIter
    assert(iter2.hasNext)
    assert(iter2.next() === 1)
    assert(iter2.hasNext)
    assert(iter2.next() === 2)
    assert(iter2.hasNext)
    assert(iter2.next() === 4)
    assert(iter2.hasNext)
    assert(iter2.next() === 5)
    assert(iter2.hasNext)
    assert(iter2.next() === 8)
    assert(iter2.hasNext)
    assert(iter2.next() === 9)
    assert(!iter2.hasNext)

    val iter3 = MergeIterator.empty
    assert(!iter3.hasNext)
  }
}
