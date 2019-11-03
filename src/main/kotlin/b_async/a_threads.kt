package b_async

import kotlin.concurrent.thread

class ThreadClass() {
  
  init {
    thread(name = "a") { job() }
    thread(name = "b") { job() }
    thread(name = "c") { job() }
    thread(name = "d") { job() }
    thread(name = "e") { job() }
    thread(name = "f") { job() }
  }
  
  fun job() {
    for (i in 0..1000) {
      var count = 0.0
      for (j in 0..10000000) {
        count += Math.sqrt(j.toDouble())
      }
      println("${Thread.currentThread().name}: $i")
    }
  }
}


fun main() {
  ThreadClass()
}