package org.x4444.csscala.queue

import scala.collection.mutable

/**
  * Created by alexanderpivovarov on 9/30/16.
  */

/**
  * Write a class that takes a steady stream of data points and spits out
  * the average of those data points over some window sized N.
  * *
  * MetricsAggregator ma = new MetricsAggregator()
  *ma.add(10) //adds 10
  *ma.avg() // 10
  *ma.add(20) //adds 20
  *ma.avg() // 15
  *ma.add(20)
  *ma.avg() // 16.666
  */
object Solution extends App {
  val ma = new MetricsAggregator(3)
  ma.avg()
  ma.add(10) //adds 10
  ma.avg() // 10
  ma.add(20) //adds 20
  ma.avg() // 15
  ma.add(20)
  ma.avg() // 16.666
  ma.add(20)
  ma.avg() // 20.0
}

class MetricsAggregator(val wSize: Int) {

  val queue = mutable.Queue[Double]()
  var sum = 0.0
  // we can use None or null here
  var av: Double = Double.NaN

  def add(v: Double): Unit = {
    if (queue.size < wSize) {
      sum += v
    } else {
      val first = queue.dequeue()
      sum = sum - first + v
    }
    queue += v

    av = sum / queue.size
  }

  def avg(): Double = {
    println(av)
    av
  }

}

