package com.github.kornilova_l.coloring.graph


class Graph(nodeIds: Set[Int], connections: Map[Int, Set[Int]], colors: Map[Int, Int]) {
  val nodes: Map[Int, Node] = (
    for (nodeId <- nodeIds)
      yield nodeId -> new Node(nodeId, connections.getOrElse(nodeId, Set[Int]()), colors(nodeId))
    ) toMap
}

class Node(val id: Int, val neighbours: Set[Int], val color: Int) {
  override def toString: String = s"id: $id color: $color neighbours: $neighbours"
}
