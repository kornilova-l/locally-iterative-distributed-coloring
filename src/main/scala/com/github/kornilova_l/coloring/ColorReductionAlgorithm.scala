package com.github.kornilova_l.coloring

import com.github.kornilova_l.coloring.graph.{Graph, Node}

class ColorReductionAlgorithm(graph: Graph) {

  private val initialNumberOfColors = graph.nodes.maxBy(it => it._1)._1
  private val finalNumberOfColors = Math.ceil(Math.sqrt(initialNumberOfColors)) toInt

  private val primeNumber = (finalNumberOfColors to 2 * finalNumberOfColors).find(num => isPrime(num)).get

  private val colorNodes = for {
    (id, node) <- graph.nodes
  } yield id -> new ColorReductionNode(node)

  def isPrime(i: Int): Boolean =
    if (i <= 1) false
    else if (i == 2) true
    else !(2 until i).exists(x => i % x == 0)

  def reduceColors(): Unit = {
    while (!allNodesTerminated()) {
      colorNodes.foreach { case (_, colorNode) =>
        if (colorNode.hasConflict)
          colorNode.b = (colorNode.a + colorNode.b) % primeNumber
        else
          colorNode.a = 0
      }
    }
  }

  def allNodesTerminated(): Boolean = colorNodes.forall { case (_, colorNode) => colorNode.terminated }

  class ColorReductionNode(val node: Node) {
    var (a, b) = (node.id / primeNumber, node.id % primeNumber)

    def terminated: Boolean = a == 0

    def hasConflict: Boolean = node.neighbours.exists { neighbourId => b == colorNodes(neighbourId).b }

    override def toString: String = s"<$a, $b> $node"
  }

}
