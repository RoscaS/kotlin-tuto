package d_AI.a_Genetics.dataStructures

data class Gene(val key: String, val type: Type) {
  override fun toString() = key

  fun shouldMutate() = (1..1000).random() == 1
}

