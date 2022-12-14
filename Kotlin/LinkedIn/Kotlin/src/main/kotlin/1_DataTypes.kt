// SECTION # 1

fun main(args: Array<String>) {
//Mutable VS Read-Only Variables
    // var vs val
    // --------------- Boolean Data type ---------------
    println("\n--------------- Boolean Data type ---------------")
    // read-only variable Boolean data type, that holds a value true
    val ourFirstVariable: Boolean = true
    println(ourFirstVariable)
    // ourFirstVariable =  false -> will not compile as the variable cannot be reassigned

    // mutable variable that holds value of true
    // Even we do not explicitly declare Boolean type the Kotlin compiler still understands that
    // our first variable is of type Boolean because we assigned it a Boolean value of true
    var ourSecondVariable = true // we do not need explicit type declaration
    ourSecondVariable = false // we can reassign as it is mutable


    // --------------- Numeric Data types ---------------
    // Int - 32 bits (default numeric type)
    // Byte - 8 bits
    // Short - 16 bits
    // Long - 64 bits
    // Double - 64 bits
    // Float - 32 bits

    val aInt: Int = 0
    val anotherInt = 0

    val aLong: Long = 0
    val anotherLong = 10L

    val unsignedInt: UInt = 0U
    val unsignedLong = 0UL

    val aDouble: Double = 5.0 // Double is by default data type
    val aFloat: Float = 5.5f

    println("\n--------------- Numeric Data types ---------------")
    println(10.5.toInt()) // 10
    println((-10.5).toUInt()) // 0
    println(100_000_000.toByte()) // 0


    // --------------- Text-Based Data types ---------------
    // Char
    // String

    val aChar: Char = 'a' // single-quote
    val aNumericChar: Char = '1'
    val newLine: Char = '\n'

    val aString: String = "Hello Kotlin!"

    // Raw String - triple quotes
    val rawString = """
    Some 
      multiline
        text
      is going on
                     here
    """

    val rawString2 = """
    |Some 
      multiline
        text
      is going on
                     |here
    """.trimMargin()

    println("\n--------------- Text-Based Data types ---------------")
    println(rawString)
    println(rawString2)

    // --------------- Concatenation ---------------
    val concatString = "Hello " + " Kotlin"
    val concatNumber = "The number " + 11

    println("\n--------------- Concatenation ---------------")
    println(concatString)
    println(concatNumber)

    // --------------- String templates ---------------
    val aNumber = 10
    val concatTemplate = "The number $aNumber" // placeholder $ + variable
    println("\n--------------- String templates ---------------")
    println(concatTemplate)
    // this time we didn't create multiple strings to generate the output, instead we used string templating

    // placeholder ${} we can use to run code in there
    val concatTemplateWithCode = "The number added 1 ${aNumber + 1}"
    println(concatTemplateWithCode)

    // --------------- String functions ---------------
    val someString = " "
    val anotherString = "Hello Kotlin!"

    println("\n--------------- String functions ---------------")
    println("isEmpty() is " + someString.isEmpty())
    println("isNotEmpty() is " + someString.isNotEmpty()) // blank characters are not empty
    println("isNotBlank() is " + someString.isNotBlank()) // checks for white spase characters

    println(anotherString.contains("Kotlin"))
    println(anotherString.contentEquals("Kotlin"))


    // --------------- Nullable functions ---------------
    // var aNullableString: String = null // compiler will not compile
    var aNullableString: String? = null // turn it to nullable type

    // println(aNullableString.length) // compiler will not compile

    // The least safe option is to add double exclamation mark before the property access
    // println(aNullableString!!.length) // not a safe option - > in this case we will get NullPointerException

    // Null Safe Call
    println(aNullableString?.length) //  only access of property or call a method if the value is not null
    //So, it will prevent the NullPointerException and return null instead.
    // So, if the value is null,the program will not crush, but instead it will print null in the console, which is also not very useful.

    // Elvis operator
    // The Elvis operator allows us to evaluate an expression and return some default value if that expression evaluates to null.
    println(aNullableString?.length ?: "the value was null")

    aNullableString = "Kotlin"
    println(aNullableString.length)
}