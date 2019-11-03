package a_basic

// var: setter auto, val: no setter
class User(var email: String, val password: String, var age: Int)

// no var nor val: allows custom getter & setter
class SuperUser(email: String,
                private var password: String,
                var age: Int = 65) {

  var email: String = email
    get() {
      println("User is getting his email"); return field
    }
    set(value) {
      println("User is setting his email"); field = value
    }

}


fun useUser() {
  val u1 = User("bob.garcia@gmail.com", "popo", 41)
  val u2 = User(age = 32, email = "sol.rosca@gmail.com", password = "lala")

  println(u2.age)
  u2.age = 30
  println(u2.age)
}

fun main() {
  //    useUser()
  val su = SuperUser("sol.rosca@gmail.com", "lala")
  //    println(su.age)
}