package a_basic

abstract class Button {
  open fun show() {}
  open fun hide() {}
  final fun print() {}
  abstract fun jump()
}

class CircularButton : Button() {
  override fun show() {}
  override fun hide() {}
  override fun jump() {}
}

open class Animal(var color: String) {
  init {
    println("Animal created")
  }
  
  constructor() : this("#FFF")
}

class Cat(color: String) : Animal(color)

// Data class: auto defines toString, hashCode, equals, copy
data class Dude(var email: String,
                var password: String,
                var isConneced: Boolean = true)


fun main() {
  val dude1 = Dude("tata@gmail.com", "qwerty")
  val dude2 = Dude("titi@gmail.com", "qwerty", false)
  
  println(dude1.toString())
  
  // comparaison
  if (dude2 == dude1) println("Users are equal")
  else println("Users are not equal...")
  
  // clone
  val clonedDude = dude1.copy()
  if (clonedDude == dude1) println("Users are equal")
  else println("Users are not equal...")
  
}