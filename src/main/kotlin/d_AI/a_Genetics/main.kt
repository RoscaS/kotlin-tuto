package d_AI.a_Genetics

import d_AI.a_Genetics.dataStructures.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

fun main() {

  (1..9).forEach { GenesPool.add(it.toString(), Type.VALUE) }
  "+-*/".forEach { GenesPool.add(it.toString(), Type.OPERATOR) }

  val time = measureTimeMillis {
    val goal = 200f
    // val pop = Population(count = 10, goal = goal)
    // pop.population.sortBy { it.fitness }
    // pop.selection()




    // var c1 = Chromosome()
    // c1.createChromosome()

    val pop = Population(count = 50, goal = goal)

    for (i in (1..20)) {
      // GlobalScope.launch {
      //   Chromosome.count = 0
        // for (i in pop.population) println(i)
        pop.iterate()
      // }
    }
  }


  println("${time}ms")
}


// 46218ms Threaded
// 83737ms without threads