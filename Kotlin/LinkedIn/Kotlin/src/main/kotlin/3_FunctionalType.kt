// SECTION # 3

// Functions in Kotlin can be used as data types
//We can define a variable with a functional type.
// Rather than using an explicitly-named type, such as string,
// we must describe the function signature for the function type we want to work with.
// Specifically, we must specify what arguments are needed by the function and
// what the return type should be.

//          no parameters (), dash and arrow -> desired return type like Unit
// var greetingFunction: () -> Unit // we have not yet initialized here
var greetingFunction: () -> Unit = { // Lambda
    println("Hello Kotlin!")
}

// function with parameters and return
var greetingFunctionWithArgumentsAndReturnType: (String) -> String = {
    // this implicit "it" parameter , or "it" variable,
    // it is implicitly given name for the parameter passed to the function
   "Hello $it!" // special property of Lambda - there is no return keyword
    // This is a special property of lambdas. Within a lambda you don't have to
    // explicitly return the value using the return key word.
    // Whatever the last value is within the lambda will be implicitly return.
}

// renamed "it"
var greetingFunctionWithArgumentsAndReturnTypeAndRenamedIT: (String) -> String = { itRenamedParameter ->
    "Hello $itRenamedParameter!"
}

fun main() {
    greetingFunction() // Hello Kotlin!
    // they are the same way invoked or called
    greetingFunction.invoke() // Hello Kotlin!

    // Reassign the function
    greetingFunction = {
        println("Hello reassigned function!")
    }
    greetingFunction() // Hello reassigned function!

    greetingFunctionWithArgumentsAndReturnType("World")
    println(greetingFunctionWithArgumentsAndReturnType("World")) // Hello World!

    greetingFunctionWithArgumentsAndReturnTypeAndRenamedIT("Kotlin")
    println(greetingFunctionWithArgumentsAndReturnTypeAndRenamedIT("Kotlin")) // Hello Kotlin!

    greetingFunctionWithArgumentsAndReturnTypeAndRenamedIT = {
        "Hey $it."
    }

    // why this function will not be in the console?
    greetingFunctionWithArgumentsAndReturnTypeAndRenamedIT.invoke("reassigned function with return type")

    // As our function has nor print function, but return String, we need to print in order to see it in the console
    println(greetingFunctionWithArgumentsAndReturnTypeAndRenamedIT.invoke("reassigned function with return type"))
}

// Functional types are the foundation of another powerful feature of Kotlin, higher-order functions.