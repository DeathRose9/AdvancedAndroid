// SECTION # 8

// Smart casting
// ClassCastException
// To cast a value means that we explicitly change the type of the variable
// or property to some new specific type.

// Sometimes we may want conditional logic that runs only for certain data types.
// Perhaps we want to print one message if our variable is an int, and another message
// is our variable is of type string. In a production code base, having to repeatedly
// make these kinds of type checks can result in verbose, difficult-to-follow code.
// To help alleviate this issue, Kotlin includes the notion of smart casting.

fun checkType(input: Any?) {
    when (input) {
        null -> println("Input was null")
        is String -> println("Input was a String of length ${input.length}")
        !is String -> println("Input $input was not a String")
    }
}

fun main() {
    val aGenericVariable: Any = 5
    val anIntVariable: Int = aGenericVariable as Int
    // If aGenericVariable had a String value, we would get ClassCastException
    // So, we need to check the type of value

    checkType("null")
    checkType(anIntVariable)
}