package b_async

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun doSomethingUsefulOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun doSomethingUsefulTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}

fun somethingUsefullOneAssync() = GlobalScope.async {
  doSomethingUsefulOne()
}

fun somethingUsefullTwoAssync() = GlobalScope.async {
  doSomethingUsefulTwo()
}


fun main() {
  val time = measureTimeMillis {
    // we can initiate async actions outside of a coroutine
    val one = somethingUsefullOneAssync()
    val two = somethingUsefullTwoAssync()

    // but waiting for a result must involve either suspending
    // or blocking. Here we use `runBlocking{ ... }` to block
    // the main thread while waiting for the result.

    runBlocking {
      println("The answer is ${one.await() + two.await()}")
    }
  }
  println("completed in $time ms.")
}