package c_tests.graph

data class Node(val x: Int, val y: Int) {
  var start = false
  var visited = 0
  var literal = "${x.toString().padStart(2)},${y.toString().padStart(2)}"
  lateinit var neighbors: List<Node>

  override fun toString(): String {
      if (start) return "[START]"
      if (visited > 0) return "[${visited.toString().padStart(5)}]"
      return "[$literal]"
  }

  fun isDiscovered(): Boolean {
    return visited > 0
  }
}