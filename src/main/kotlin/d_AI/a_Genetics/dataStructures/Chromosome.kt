package d_AI.a_Genetics.dataStructures

import java.text.DecimalFormat


data class Chromosome(val genes: MutableList<Gene> = mutableListOf()) {

  companion object {
    val GENES = 8
    var count = 0
  }

  init {
    createChromosome()
  }

  /*------------------------------------------------------------------*\
  |*							              ATTRIBUTES
  \*------------------------------------------------------------------*/

  var id = ++count
  var parentId = -1
  val name = id.toString().padStart(3, '0')
  val solution = computeSolution()
  val size = genes.size
  var fitness = 0

  /*------------------------------------------------------------------*\
  |*							               METHODES
  \*------------------------------------------------------------------*/

  fun copy():Chromosome {
    val c = Chromosome(genes)
    c.parentId = id
    return c

  }



  fun keyList() = genes.map { it.key }
  fun readable() = keyList().joinToString(" ") { it }

  fun shouldMate() = (1..10).random() <= 7


  private fun createChromosome() {
    if (genes.isNotEmpty()) return

    genes.add(GenesPool.getRandomValue())
    // for (i in (1..(0..(GENES / 2) - 1).random())) {
    for (i in (1..GENES/2)) {
      genes.add(GenesPool.getRandomOperator())
      genes.add(GenesPool.getRandomValue())
    }
  }

  private fun computeSolution(): Float {
    val keys = keyList().toMutableList()

    if (keys.size == 0) return 0.0f
    if (keys.size == 1) return keys[0].toFloat()

    val iterations = (keys.size / 2) - 1

    var left = keys.removeAt(0).toFloat()
    var operation = keys.removeAt(0)
    var right = keys.removeAt(0).toFloat()

    for (c in (0..iterations)) {
      when (operation) {
        "+" -> left = left + right
        "-" -> left = left - right
        "*" -> left = left * right
        "/" -> left = left / right
      }
      if (keys.size >= 2) {
        operation = keys.removeAt(0)
        right = keys.removeAt(0).toFloat()
      }
    }
    return left;
  }

  override fun toString(): String {
    val format = { x: Number? -> DecimalFormat("####.##").format(x) }
    val name = "C$name".padEnd(8, ' ')
    val parentId = "C$parentId".padEnd(8, ' ')
    val solution = "sol: ${format(solution)}".padEnd(12, ' ')
    val score = "score: ${format(fitness)}".padEnd(18, ' ')
    val readable = readable().padEnd(18, ' ')


    return "$name $parentId $solution $score $readable"
  }

}