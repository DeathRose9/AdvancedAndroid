// SECTION # 5

// if and when statements

// How do we define conditional logic in Kotlin? For this problem,
// we have two primary tools: if and when, both of which can be used as
// both a statement or an expression. An expression returns a values,
// whereas a statement does not.

fun main() {
    var someVariable = 100
// if statements can be written with or without curly braces.
// If we want to run multiple lines of code in response to some condition,
// curly braces can help us organize that code and make it more readable.

//And just like with the if condition, the else block can also be
// wrapped in curly braces to make it easier to read and to support adding
// more complex logic down the line.

    // if-else
    if (someVariable > 3) {
        println("The value was greater than 3")
    } else if (someVariable > 2) {
        println("The value was greater than 2")
    } else {
        println("Not greater")
    }

    // when
    // And similar again to if else, we could wrap any of these code blocks
    // in curly braces if we needed more complex logic
    when {
        someVariable > 3 -> println("The value was greater than 3")
        someVariable > 2 -> println("The value was greater than 2")
         else -> println("Not greater")
//        else -> {
//            println("Not greater")
//        }
    }

// Why is this syntax useful? Well, in cases where we might be supplying
// multiple conditionals, all operating on a single variable, passing the variable into
// "when" allows us to implicitly reference the variable, saving us code.
    when (someVariable) {
        0, 1 -> println("The value was 0 or 1")
        2 -> println("The value is 2")
        3 -> println("The value is 3")
        in 4..Int.MAX_VALUE -> println("The value was greater than 3")
    }
}