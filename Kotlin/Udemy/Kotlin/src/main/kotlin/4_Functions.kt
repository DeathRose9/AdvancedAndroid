import java.util.*

fun main() {
    helloWorld()
    printWithSpaces("KOTLIN")
    println(getCurrentDate())
    println(max(18, 82))
}

// no parameters, no return value
fun helloWorld() {
    println("Hello world!")
}

// one parameter, no return value
//"KOTLIN" -> "K O T L I N"
fun printWithSpaces(text: String) {
    for (char in text) {
        print("$char ")
        //print(char + " ")
    }
    println()
}

// no parameters, returns Date
fun getCurrentDate(): Date {
    return Date()
}
// fun getCurrentDate() = Date()

// two parameters, returns Int
fun max(a: Int, b: Int): Int {
    if (a >= b) {
        return a
    } else {
        return b
    }
}