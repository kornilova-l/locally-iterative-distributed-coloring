package com.github.kornilova_l.coloring.graph

import scala.collection.mutable
import scala.util.Random

class GraphGenerator(size: Int, maximumDegree: Int, density: Float = 0.8f) {
  val graph = new Graph()

  {
    for (i <- 1 to size) {
      graph.addNode(i)
    }

    val connectionsCount = mutable.Map[Int, Int]()

    val random = new Random()

    for (i <- 0 to Math.floor(size * maximumDegree * density).toInt) {
      val id1 = random.nextInt(size - 1) + 1
      val id2 = random.nextInt(size - 1) + 1

      val node1ConnectionsCount = connectionsCount.getOrElse(id1, 0)
      val node2ConnectionsCount = connectionsCount.getOrElse(id2, 0)

      if (id1 != id2 &&
        node1ConnectionsCount < maximumDegree &&
        node2ConnectionsCount < maximumDegree) {

        graph.addConnection(id1, id2)
        connectionsCount.update(id1, node1ConnectionsCount + 1)
        connectionsCount.update(id2, node2ConnectionsCount + 1)
      }
    }
  }
}
