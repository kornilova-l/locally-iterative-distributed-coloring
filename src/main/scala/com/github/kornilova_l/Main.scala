package com.github.kornilova_l

import com.github.kornilova_l.coloring.ColorReductionAlgorithm
import com.github.kornilova_l.coloring.graph.GraphGenerator

object Main {
  def main(args: Array[String]): Unit = {
    val graph = new GraphGenerator(100, 5).graph
    val colorReductionAlgorithm = new ColorReductionAlgorithm(graph)
    val graphWithReducedColors = colorReductionAlgorithm.reduceColors()
  }
}
