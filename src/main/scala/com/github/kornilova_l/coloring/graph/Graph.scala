package com.github.kornilova_l.coloring.graph

import scala.collection.mutable

class Graph {
  private val nodes = mutable.Map[Int, Node]()

  def addNode(id: Int) {
    if (nodes.contains(id)) {
      throw new IllegalArgumentException(s"This id already exist in node: $id")
    }
    nodes.update(id, new Node(id))
  }

  def addConnection(id1: Int, id2: Int): Unit = {
    if (!nodes.contains(id1) || !nodes.contains(id2)) {
      throw new IllegalArgumentException(s"One or both ids do not exist in tree: $id1 $id2")
    }
    val node1 = nodes(id1)
    val node2 = nodes(id2)

    node1.addNeighbour(node2)
    node2.addNeighbour(node1)
  }

  private class Node(val id: Int) {
    private val neighbours = mutable.HashSet[Node]()

    def addNeighbour(neighbour: Node): Unit = {
      neighbours add neighbour
    }
  }

}
