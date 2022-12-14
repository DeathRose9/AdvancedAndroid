// SECTION # 7

fun main() {
    // we can use try catch as an expression to write more concise, error-safe code

// because we used try-catch, our program will not crash, because we handle the error
    try {
        val message = "The value is ${10 / 0}"
// in this case, we are catching any throwable,
// even if we know that we expect an arithmetic exception
    } catch (error: Throwable) {
        println("Error was thrown")
    }
    //Handling the error in this way, branches the normal execution of our code.So ...


// Sometimes a potential error might be expected and recoverable.
// In cases like that, we can use try catch as an expression to streamline
// the error handling and reduce the number of logical branches in our code.
    val message = try {
        throw IllegalStateException()
        "The value is ${10 / 0}"
    } catch (error: ArithmeticException) {
        "Error was thrown"
    } catch (error: java.lang.IllegalStateException) {
        "Error was IllegalState"
    }
    println(message)
}