package c_tests.graph

import com.andreapivetta.kolor.Color
import com.andreapivetta.kolor.Kolor
import java.util.*
import java.util.stream.Collectors

class Graph(val width: Int, val height: Int) {
  /*------------------------------------------------------------------*\
  |*							                STATIC
  \*------------------------------------------------------------------*/

  companion object {
    val DIRECTIONS = mutableListOf(
      Node(1, 0),
      Node(0, 1),
      Node(-1, 0),
      Node(0, -1)
    )
  }

  /*------------------------------------------------------------------*\
  |*							                ATTRIBUTES
  \*------------------------------------------------------------------*/

  var nodes = mutableListOf<Node>()
  var iterations = 0

  /*------------------------------------------------------------------*\
  |*							                INITIALIZATION
  \*------------------------------------------------------------------*/

  init {
    for (y in 0..height - 1) for (x in 0..width - 1) nodes.add(Node(x, y))
    for (node in nodes) node.neighbors = neighbors(node)
  }

  /*------------------------------------------------------------------*\
  |*							                METHDOES
  \*------------------------------------------------------------------*/

  fun getNode(x: Int, y: Int): Node? =
    nodes.find { node -> node.x == x && node.y == y }

  /*------------------------------*\
  |*			     STRATEGIES
  \*------------------------------*/

  fun deepFirstExploration(start: Node) {
    val frontier: Stack<Node> = Stack()
    frontier.add(start)
    val visited: MutableSet<Node> = mutableSetOf(start)
    while (frontier.isNotEmpty()) {
      val current = frontier.pop()

      render(current, frontier)

      for (next in current.neighbors) {
        if (!visited.contains(next)) {
          frontier.add(next)
          visited.add(next)
        }
      }
    }
    iterations = 0
  }

  fun breadthFirstExploration(start: Node) {
    val frontier: Deque<Node> = ArrayDeque(listOf(start))
    val visited: MutableSet<Node> = mutableSetOf(start)
    while (frontier.isNotEmpty()) {
      val current = frontier.pop()

      render(current, frontier.stream().collect(Collectors.toList()))

      for (next in current.neighbors) {
        if (!visited.contains(next)) {
          frontier.addLast(next)
          visited.add(next)
        }
      }
    }
    iterations = 0
  }

  /*------------------------------*\
  |*			        PRIVATE
  \*------------------------------*/

  private fun neighbors(node: Node): MutableList<Node> {
    val result = mutableListOf<Node>()
    for (direction in DIRECTIONS) {
      val x = node.x + direction.x
      val y = node.y + direction.y
      val neighbor: Node? = getNode(x, y)
      if (neighbor != null) result.add(neighbor)
    }
    return result
  }

  private fun render(current: Node, frontier: List<Node>) {
    current.visited = iterations++
    println("\n\n\n\n\n\n\n\n\n")
    for ((c, node) in nodes.withIndex()) {
      if (c % width == 0 && c != 0) println()
      if (node == current) {
        print(Kolor.background(node.toString(), Color.GREEN))
      }
      else if(node.start) {
        print(Kolor.foreground(node.toString(), Color.LIGHT_GREEN))
      }
      else {
        if (node.isDiscovered()) {
          print(Kolor.foreground(node.toString(), Color.DARK_GRAY))
        }
        else if (frontier.contains(node)) {
          print(Kolor.foreground(node.toString(), Color.LIGHT_BLUE))
        }
        else if (current.neighbors.contains(node) &&
          !node.isDiscovered() && !frontier.contains(node)) {
          print(Kolor.background(node.toString(), Color.LIGHT_BLUE))
        }
        else {
          print(node)
        }
      }
    }
    Thread.sleep(200)
  }

  /*------------------------------*\
  |*			        OVERRIDE
  \*------------------------------*/

  override fun toString(): String {
    var s = ""
    for ((c, node) in nodes.withIndex()) {
      if (c % width == 0 && c != 0) s += "\n"
      s += node.toString()
    }
    return s
  }
}


