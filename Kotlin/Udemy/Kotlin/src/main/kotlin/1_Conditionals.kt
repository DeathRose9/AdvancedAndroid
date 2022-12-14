
import java.util.*

fun main() {

    // If statements
    val age: Int = 21
    if (age < 18) {
        println("You cannot register")
    } else if (age < 21) {
        println("You should be able to register")
    } else {
        println("You're good to go!")
    }


    // When statements
    var mode: Int = 2
    when (mode) {
        1 -> println("The mode is lazy.")
        2 -> {
            println("The mode is 2.")
            println("So, the mode is busy.")

        }
        3 -> println("The mode is super-productive.")
        else -> println("There is no such mode")


    }
    mode = 3
    val result = when (mode) {
        1 -> "The mode is lazy."
        2 -> {
            println("The mode is 2.")
            val i: Int = 8
            "So, the mode is busy."
        }
        3 -> "The mode is super-productive."
        else -> "There is no such mode"
    }

    println(result)
/*
val random = Random().nextInt(50) + 1
IntelliJ helps you import the Random class from Java so that you can use it.
Don’t worry about the details of imports for now.
Now, use a when statement to switch between the cases where random is in the
range 1 to 10, 11 to 20, 21 to 30, 31 to 40, or above 40. In each case,
print out a message containing the range and the exact value of random.
Test your code in a main() function and run it several times to get different random numbers.
* */
    val random = Random().nextInt(50) + 1

    when (random) {
        in 1..10 -> println("In 1 to 10: $random")
        in 11..20 -> println("In 11 to 20: $random")
        in 21..30 -> println("In 21 to 30: $random")
        in 31..40 -> println("In 31 to 40: $random")
        !in 1..50 -> println("Just for the sake of example") // this codeline will not work
        else -> println("Over 40: $random")
    }
}