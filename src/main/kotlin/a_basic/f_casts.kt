package a_basic

fun longExample(anyObject: Any): Int {
  if (anyObject is String) { // is -> smart cast
    return anyObject.length
  } else if (anyObject is List<*>) {
    return anyObject.size
  }
  return 0
}

fun getDefaultSize(anyObject: Any) = when (anyObject) {
  is String  -> anyObject.length
  is List<*> -> anyObject.size
  else       -> 0
}

fun cast() {
  val anyObject: Any = "Hello Kotlin"
  val message = anyObject as String // cast from Any to String (NOT SAFE)
  println(message)
}

fun exceptions() {
  val anyObject: Any = "Hello Kotlin"
  
  try {
    val message = anyObject as Int
    print(message)
  } catch (exception: ClassCastException) {
    print("Error !")
  }
  
  // Better
  val anotherObject: Any = "Hello Kotkot"
  val msg: Int? = anotherObject as? Int // if cast fail msg = null
  print(msg)
}

fun main() {

}