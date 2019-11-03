package c_tests.graph

fun main() {

  val map = Graph(25, 30)
  val start = map.getNode(12, 15)
  start!!.start = true

  map.breadthFirstExploration(start)
  // map.deepFirstExploration(start)

}