package a_basic


data class Guy(var name: String, var age: Int)

fun main() {
  val add = { x: Int, y: Int -> x + y }
  println(add(2, 3))
  
  val sub = { x: Int, y: Int -> x - y }
  val div = { x: Int, y: Int -> x / y }
  
  fun exec(x: Int, y: Int, operation: (Int, Int) -> Int) = operation(x, y)
  
  println(exec(10, 5, { x, y -> x * y }))
  
  val guys = listOf(
    Guy("Joe", 31),
    Guy("Vlad", 46),
    Guy("Pat", 24)
  )
  
  var poule: Double
  
  println(guys.maxBy { it.age }) // find oldest
  println(guys.filter { it.age >= 20 }) // filter
  println(guys.map { it.name }) // list of names
  println(guys.filter { it.age >= 30 }.map { it.name }) // name of guys older than 20
  
  println(guys.all { it.age >= 30 }) // false
  println(guys.any { it.age >= 30 }) // true
  println(guys.count { it.age >= 30 }) // 2
  println(guys.find { it.age >= 30 }) // find first Guy older tan 30
}