package d_AI.a_Genetics.dataStructures

import kotlin.math.abs
import kotlin.math.roundToInt

class Population(val count: Int = 50, val goal: Float) {

  companion object {
    val CHAMPIONS = 10
    fun fitnessFunction(x: Float, g: Float) =
      (abs(1 / (g - x)) * 1000000).toInt()
  }

  /*------------------------------------------------------------------*\
  |*							              ATTRIBUTES
  \*------------------------------------------------------------------*/

  private var iteration = 1

  private var totalFitness = 0
  private var population = (1..count).map { Chromosome() }.toMutableList()

  lateinit var champions: List<Chromosome>
  lateinit var rates: List<Float>
  lateinit var cum: MutableList<Float>

  /*------------------------------------------------------------------*\
  |*							                INITIALIZATION
  \*------------------------------------------------------------------*/

  // init {
  //   setupNewGeneration()
  // }

  private fun setupNewGeneration() {
    population.forEach { it.fitness = fitnessFunction(it.solution, goal) }
    population.sortByDescending { it.fitness }
    champions = population.take(CHAMPIONS)
    totalFitness = champions.sumBy { it.fitness }
    rates = champions.map { (it.fitness.toFloat() / totalFitness) * 100 }
    cum = champions.map { rates.subList(0, champions.indexOf(it)).sum() }
      .toMutableList()
    cum.removeAt(0)
    cum.add(100F)
  }

  private fun selection() {
    val selection = mutableListOf<Chromosome>()

    for (i in (1..count)) {
      val marble = (1..100).random()
      val selected = champions.get(cum.indexOf(cum.find { it >= marble }))
      val copy = selected.copy()

      for ((c, gene) in copy.genes.withIndex()) {
        if (gene.shouldMutate()) {
          println("MUTATION")
          copy.genes[c] = GenesPool.getRandomOfType(gene)
        }
      }




      println("Marble: $marble\t->\tSelected: $selected")

      selection.add(copy)
    }
    population = selection
    println(selection.map { it.name })
  }

  /*------------------------------------------------------------------*\
  |*							                METHODES
  \*------------------------------------------------------------------*/

  fun maxFitness() = population.maxBy { it.fitness }
  fun minFitness() = population.minBy { it.fitness }
  fun averageFitness() = population.map { it.fitness }.average()

  fun iterate() {
    setupNewGeneration()
    println(this)
    selection()
    setupNewGeneration()
    iteration++
  }

  override fun toString(): String {

    val header = "--------- GENERATION $iteration ---------"
    val pop = "pop: ${population.size}"
    val max = "max: ${maxFitness()?.fitness}"
    val min = "min: ${minFitness()?.fitness}"
    val avg = "avg: ${averageFitness()}"

    var s = "$header\n$pop\nFitness:\t$max \t$min \t$avg\n"

    s += "proportion / chromosome\t($CHAMPIONS best)"
    s += "\tVery indicative:\n "

    for ((c, i) in champions.withIndex()) {
      val rel = rates[c].roundToInt()
      s += (rel.toString() + "%").padStart(rel / 2).padEnd(rel)
    }
    s += "\n"

    s += "${"_".repeat(100)}\t\t~100%\n"
    for ((c, i) in champions.withIndex()) {
      val rel = rates[c].roundToInt()
      s += "${champions[c].id.toString().padStart(rel / 2).padEnd(rel - 1)}|"
    }
    s += "\t\tid\n "

    for ((c, i) in cum.withIndex()) {
      val rel = rates[c].roundToInt()
      s += cum[c].roundToInt().toString().padStart(rel)
    }
    s += "\t\ttot\n"

    // val marble = (1..100).random()
    // val selected = champions.get(cum.indexOf(cum.find { it >= marble }))
    // s += " ".repeat(marble) + "^\n"
    // s += "${" ".repeat(marble)}${marble + 1} (marble)\n"
    // s += "\nC${selected.name} selected !"

    return s
  }
}