package a_basic


open class Person() {

    lateinit var name: String

    init {
        println("Person init")
    }
    constructor(name: String) : this() {
        println("Person cstr")
    }
}

class Worker() : Person() {
    init {
        println("Worker init")
    }

    constructor(name: String) : this() {
        this.name = name
        println("Worker cstr")
    }
}


fun main() {

    val p1 = Worker("Sol")

}