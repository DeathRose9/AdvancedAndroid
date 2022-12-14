// SECTION # 2

// In Kotlin, we can write and use functions without any kind of enclosing class or struct
// Access modifiers are : public, private, internal
// fun keyword, that represents it is  function + function name + parenthesis,
// where we can put arguments + function body inside curly braces
fun main(): Unit { // non-meaningful return type Unit written explicitly
    println(getGreeting()) // -> Hello world!
    println(getGreetingWithNoExplicitReturnType()) // -> Hello world!
    printGreetingWithUnitTypeReturn() // ->Hello Unit Function!

    // Local function
    fun getGreetingLocalFunction() = "Hello Local Function!"

    assignToAnotherFunction() // Hello world!

    // Calling a function with argument
    println(getGreetingWithArguments("John")) //-> Hello John!
    println(getGreetingWithDefaultArgumentValue()) // we do not need to pass argument -> Hello world!
    namedArgumentFunction("John") // John world! -> so we should use named argument
    namedArgumentFunction(argumentTwo = "John") // named argument -> Hello  John!
    namedArgumentFunction(argumentTwo = "John", argumentOne = "Hey") // named argument with no order -> Hey John!
}

fun getGreeting(): String { // returns String
    return "Hello world!"
}

// Single expression function
fun getGreetingWithNoExplicitReturnType() = "Hello world!" // return type is String

fun printGreetingWithUnitTypeReturn() = println("Hello Unit Function!")

// Local function
// A local function is a function defined inside another function
// For example getGreetingLocalFunction() is inside main function,
// so it is local function and cannot be accessed outside of main function

fun assignToAnotherFunction() = println(getGreetingWithNoExplicitReturnType())
//fun assignToAnotherLocalFunction() = println(getGreetingLocalFunction())
// will not compile as we use a local function from main function

// Functions with arguments
fun getGreetingWithArguments(strArgument: String) = "Hello $strArgument!"

// Default Argument value
fun getGreetingWithDefaultArgumentValue(strArgument: String = "world") = "Hello $strArgument!"

// Named Arguments
fun namedArgumentFunction(argumentOne: String = "Hello ", argumentTwo: String = "world") =
    println("$argumentOne $argumentTwo!")



