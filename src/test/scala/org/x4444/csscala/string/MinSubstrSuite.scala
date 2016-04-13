package org.x4444.csscala.string

import org.scalatest.FunSuite

class MinSubstrSuite extends FunSuite {

  test("getCandidate") {
    assert(MinSubstr.getCandidate(0, 0, "aabbcc", Set('a', 'c')) == Some((0, 4)))
    assert(MinSubstr.getCandidate(1, 1, "aabbcc", Set('a', 'c')) == Some((1, 4)))
    assert(MinSubstr.getCandidate(1, 1, "aabbcc", Set('a', 'b')) == Some((1, 2)))
    assert(MinSubstr.getCandidate(1, 1, "aabbcc", Set('a', 'd')).isEmpty)
    assert(MinSubstr.getCandidate(1, 1, "aabbcc", Set('z')).isEmpty)
  }

  test("getMinSubstr") {
    assert(MinSubstr.getMinSubstr("aabbcc", Set('a', 'c')) == Some((1, 4)))
    assert(MinSubstr.getMinSubstr("zasctaabbcc", Set('a', 'c')) == Some((1, 3)))
    assert(MinSubstr.getMinSubstr("aabbccfasc", Set('a', 'c')) == Some((5, 7)))
    assert(MinSubstr.getMinSubstr("aabbcc", Set('a', 'b')) == Some((1, 2)))
    assert(MinSubstr.getMinSubstr("aabbcc", Set('a', 'd')).isEmpty)
    assert(MinSubstr.getMinSubstr("aabbcc", Set('z')).isEmpty)
    assert(MinSubstr.getMinSubstr("aabbcc", Set()).isEmpty)
    assert(MinSubstr.getMinSubstr("", Set('z')).isEmpty)
  }
}
