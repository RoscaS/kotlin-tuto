package a_basic

class Course(
    private var id: Int,
    var title: String,
    val length: Int,
    var state: Boolean = true
)

fun main() {
    val c1 = Course(1, "Kotlin", 22)
    println(c1.title)
}