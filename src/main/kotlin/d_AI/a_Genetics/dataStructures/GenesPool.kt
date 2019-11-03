package d_AI.a_Genetics.dataStructures

class GenesPool {

  companion object {
    val pool = mutableListOf<Gene>()

    fun size() = pool.size;

    fun getRandom() = pool.shuffled().get(0)

    fun getValues() = pool.filter { it.type == Type.VALUE }

    fun getOperators() = pool.filter { it.type == Type.OPERATOR }

    fun getRandomValue() = getValues().shuffled().get(0)

    fun getRandomOperator() = getOperators().shuffled().get(0)

    // fun byKey(key: String): Gene? = pool.find { it.key == key }

    fun add(key: String, type: Type) = pool.add(Gene(key, type))

    fun getRandomOfType(gene: Gene): Gene {
      if (gene.type == Type.VALUE) return getRandomValue()
      else return getRandomOperator()
    }


    override fun toString(): String {
      return "Gene pool: $pool"
    }
  }
}