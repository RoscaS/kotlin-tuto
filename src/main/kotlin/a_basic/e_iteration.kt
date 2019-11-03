package a_basic

fun forLoop() {
  val names = listOf("Jake", "Joe", "Robert")
  for (name in names) {
    println("His name is $name")
  }
  
  for (i in names.indices) {
    println("Number $i \tname: ${names[i]}")
  }
  
  println()
  
  for ((i, name) in names.withIndex()) {
    println("Number $i \tname: $name")
  }
  
  println()
  
  for (i in 1..3) println("i = $i") // 1 -> 3
  
  println()
  
  for (i in 10 downTo 1 step 2) println("i = $i")
}

fun collections() {
  val names1 = listOf("Jake", "Joe", "Robert")
  // names1[0] = "Vlad" // Error ! List is immutable
  
  val names2 = mutableListOf("Jake", "Joe", "Robert")
  names2[0] = "Vlad" // Ok
  
  val names3 = setOf("Jake", "Joe", "Robert")
  // names3.add("Vland") // Error ! Set is immutable
  
  val names4 = mutableSetOf("Jake", "Joe", "Robert")
  names4.add("Vland") // Ok
  
}


fun main() {
  forLoop()
  collections()
}

