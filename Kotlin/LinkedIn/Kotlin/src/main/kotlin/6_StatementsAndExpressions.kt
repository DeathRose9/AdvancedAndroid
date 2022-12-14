// SECTION # 6

// If and when can both be used both as statements and expressions.
// So how do we know the difference in when should we use one form or the other?
// To understand the difference and why it's important, we're going to examine
// the use of if and when as expressions to demonstrate how we can write safer,
// more concise code. A statement doesn't return any value. An expression,
// on the other hand, will either have its value returned from a function or
// assigned to a variable. We can use an if-expression to conditionally
// assign a variable's name.


fun getMessage(input: Int): String {
    return if (input > 3) {
        "Greater than 3"
    } else {
        "Not greater than 3"
    }
}

// Single-Expression Function
// single expression with multiple conditional branches
fun getMessageWithIf(input: Int) = if (input > 3) {
    "Greater than 3"
} else {
    "Not greater than 3"
}

fun getMessageWithWhen(input: Int) = when (input) {
    3 -> "Value is 3"
    else -> "Value is not 3"
}

// This can be a very useful way to concisely implement a function
// that needs to map from some input to very specific output cases and
// to help make sure that we handle all of those possible output cases.
// Using if and when as expressions allow us to unify assignment or
// return with the logic that determines the value. This can help us
// consolidate the conditional logic and helps us enforce immutability
// by allowing the conditional assignment of read-only values.

fun main() {
    var someVariable = 0

    // If we tried to remove the else here, we would get a compiler error on the if,
    // saying, "if must have both main and else branches if used as an expression,"
    var message = if (someVariable > 3) {
        "The value is 3"
    } else {
        "The value is not 3"
    }

    println(message)

    message = when (someVariable) {
        3 -> "The value is 3"
        else -> "The value is not 3"
    }

    println(message)
}