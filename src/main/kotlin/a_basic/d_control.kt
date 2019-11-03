package a_basic

enum class ApiResponse(val code: Int) {
  OK(200),
  NOT_FOUND(404),
  UNAUTHORIZED(401),
  FORBIDEN(403),
  UNKNOWN(0)
}

fun conditions() {
  var a = 10
  var b = 15
  val result = if (a > b) "yes" else "no"
  
  val long = if (result == "yes") {
    a++; a
  } else {
    b++; b
  }
  
  if (a > b) {
    println("yes")
  } else if (a == null) {
    println("null")
  } else {
    println("no")
  }
  
  if (a > b) println("yes") else println("no")
  println(if (a > b) "yes" else "no")
  
  val names = listOf("Jake", "Joe", "Robert")
  
  val test = if ("Jake" in names) "yes" else "no"
}

fun switchCase() {
  val response = 404;
  when (response) {
    200           -> println("OK")
    404           -> println("NOT FOUND")
    401           -> println("UNAUTHORIZED")
    403           -> println("FORBIDEN")
    300, 301, 302 -> println("REDIRECTION")
    else          -> println("UNKNOWN")
    
  }
  
  val another = when (response) {
    200, 201, 202 -> println("SUCCESS")
    300, 301, 302 -> println("REDIRECTION")
    else          -> println("UNKNOWN")
  }
  
  fun last(apiRespone: Int) = when (apiRespone) {
    200, 201, 202 -> println("SUCCESS")
    300, 301, 302 -> println("REDIRECTION")
    else          -> println("UNKNOWN")
  }
  
  val enumResponse: ApiResponse = ApiResponse.OK
  when (enumResponse) {
    ApiResponse.OK        -> println("OK")
    ApiResponse.NOT_FOUND -> println("NOT FOUND")
    ApiResponse.FORBIDEN  -> println("UNAUTHORIZED")
    ApiResponse.UNKNOWN   -> println("UNKNOWN")
  }
  
  val numberToFind = 55
  
  when (numberToFind) {
    in 1..33   -> println("Number is between 1 and 33")
    in 34..66  -> println("Number is between 34 and 66")
    in 67..100 -> println("Number is between 67 and 100")
  }
}

fun main() {
  conditions()
}