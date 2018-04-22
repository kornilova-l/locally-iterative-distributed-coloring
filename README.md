# Locally-Iterative Distributed Coloring
Implementation of Locally-Iterative Distributed (Delta + 1)-Coloring below Szegedy-Vishwanathan Barrier.

Original paper: https://arxiv.org/abs/1712.00285

## What is coloring?
Coloring is an assignment of _colors_ (numbers or labels) to graph vertices. 

A coloring is _proper_ if there are no two adjacent vertices that share the same color.

## What is (Delta + 1)-Coloring
(Delta + 1)-Coloring is a coloring algorithm that reduces numbers of distinct colors in graph to `Delta + 1` where `Delta` is a maximum degree of a graph.

## What is "locally-iterative"?
This means that after each computation round graph is properly colored.

## What is "Szegedy-Vishwanathan Barrier"?
In 1993 Szegedy and Vishwanathan studied this problem and derived an upper bound of O(Delta * log(Delta)) + log*(n).

This algorithm reduces number of colors in time O(Delta) + log*(n).

## Why should I care?
(Delta + 1)-Coloring is one of the most fundamental and well-studied distributed problems. It has numerous applications to resource and channel allocation, scheduling, workload balancing, etc.
