package a_basic

private lateinit var answer: String
private val question: String = "What's your name?"

fun main() {
  println(question)
  answer = "Sol"
  println("My name is $answer")
}