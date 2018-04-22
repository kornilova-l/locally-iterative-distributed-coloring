package com.github.kornilova_l.coloring

import com.github.kornilova_l.coloring.graph.{Graph, Node}

class ColorReductionAlgorithm(graph: Graph) {

  private val initialNumberOfColors = graph.nodes.maxBy(it => it._1)._1
  private val finalNumberOfColors = Math.ceil(Math.sqrt(initialNumberOfColors)) toInt

  private val primeNumber = (finalNumberOfColors to 2 * finalNumberOfColors).find(num => isPrime(num)).get

  private val colorNodes = for {
    (_, node) <- graph.nodes
  } yield new ColorReductionNode(node)

  def isPrime(i: Int): Boolean =
    if (i <= 1) false
    else if (i == 2) true
    else !(2 until i).exists(x => i % x == 0)


  class ColorReductionNode(val node: Node) {
    val (a, b) = (node.id / primeNumber, node.id % primeNumber)
  }

}
