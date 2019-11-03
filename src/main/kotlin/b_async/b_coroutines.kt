package b_async

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

fun main() {
  // b_withThread()
  // b_withCoroutines()
  b_withAsync()
  
}

fun a() {
  println("Start")
  
  
  GlobalScope.launch {
    delay(1000)
    println("Hello")
  }
  
  Thread.sleep(2000)
  println("Stop")
}

fun b_withThread() {
  val c = AtomicLong()
  
  for (i in 1..10_000_000L) {
    thread { c.addAndGet(i) }
  }
  
  println(c.get())
}

fun b_withCoroutines() {
  val c = AtomicLong()
  for (i in 1..1_000_000L) {
    GlobalScope.launch {
      c.addAndGet(i)
    }
  }
  println(c.get())
}

fun b_withAsync() {
  val deferred = (1..1_000_000).map { n -> GlobalScope.async {
    n
  } }
  
  runBlocking {
    val sum = deferred.sumBy { it.await() }
    println("Sum: $sum")
  }
  
}