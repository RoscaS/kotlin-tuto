package a_basic

fun getResult(a: Int, b: Int) = a + b
fun getNameUpper(name: String) = name.toUpperCase()
fun isName(name: String): Boolean {
  if (name == "Phill" || name == "Ambroise") {
    return true
  } else {
    return false
  }
}

fun defaultParam(name: String = "George", age: Int = 12): Int {
  return 1
}


fun main() {
  println(getResult(2, 3))
  println(getNameUpper("sol"))
  println(isName("Joe"))
}