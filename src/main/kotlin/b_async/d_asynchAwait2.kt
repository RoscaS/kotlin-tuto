package b_async

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking {
  var result = 0
  val time = measureTimeMillis {
    val third = async { thirdNumber(result) }
    val second = async { secondNumber(result) }
    val first = async { firstNumber(result) }

    result = first.await() + second.await() + third.await()

  }
  println(time)
  println(result)
}

suspend fun firstNumber(result: Int): Int {
  delay(3_000)
  println("firstNumber() done.\t Result: $result")
  return 5
}

suspend fun secondNumber(result: Int): Int {
  delay(5_000)
  println("secondNumber() done.\t Result: $result")
  return 8
}

suspend fun thirdNumber(result: Int): Int {
  delay(7_000)
  println("thirdNumber() done.\t Result: $result")
  return 10
}
