package com.github.kornilova_l.coloring.graph

import scala.collection.mutable
import scala.util.Random

class GraphGenerator(size: Int, maximumDegree: Int, density: Float = 0.8f) {
  val graph: Graph = {
    val nodeIds = (for (i <- 1 to size) yield i) toSet

    val connections = mutable.Map[Int, mutable.Set[Int]]().withDefault(_ => mutable.Set[Int]())

    val random = new Random()

    for (_ <- 0 to Math.floor(size * maximumDegree * density).toInt) {
      val id1 = random.nextInt(size - 1) + 1
      val id2 = random.nextInt(size - 1) + 1

      val neighbours1 = connections(id1)
      val neighbours2 = connections(id2)

      if (id1 != id2 &&
        neighbours1.size < maximumDegree &&
        neighbours2.size < maximumDegree) {

        neighbours1 add id2
        neighbours2 add id1

        connections += (id1 -> neighbours1)
        connections += (id2 -> neighbours2)

      }
    }
    new Graph(nodeIds, (for ((key, value) <- connections) yield key -> value.toSet) toMap)
  }
}
