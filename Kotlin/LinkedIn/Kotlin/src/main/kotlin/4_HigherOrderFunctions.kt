// SECTION # 4

fun printCalculatedValue(value1: Int, value2: Int, calculator: (Int, Int) -> Int) {
    println("The value is: ${calculator(value1, value2)}") // ${} is called String substitution
}

// function takes 2 strings for first and last name
// function takes a formatting function parameter
// function should print the result of the passed format function

fun printFormattedName(first: String, last: String, formatter: (String, String) -> String) {
    println(formatter(first, last))
}

// Function variable
val basicFormatter: (String, String) -> String = { first, last ->
    "$first $last"
}

val fancyFormatter: (String, String) -> String = { first, last ->
    "first name is $first and last name is $last"
}

fun main() {
    // Addition
    printCalculatedValue(2, 2, { value1, value2 ->
        value1 + value2
    })

    // Subtraction
    printCalculatedValue(2, 2, { value1, value2 ->
        value1 - value2
    })

    //Trailing Lambda syntax allows us to move the final Lambda of a parameter list
    // outside the parentheses. Now, what does this mean in practice? Well, if we were to
    // refactor the invocation of printCalculatedValue, what we could do here is actually
    // move the final parentheses after the second integer value we passed in and pass
    // the Lambda outside of those parentheses. So we can see here, the difference between
    // the first invocation of printCalculatedValue and the second one. In the second one,
    // the parentheses only include two and two and then the Lambda goes after. In the second one,
    // the Lambda goes within the parentheses. The first version here is trailing Lambda syntax and
    // it makes it feel a little bit more fluent when we're writing out these functions that
    // take a function argument. By applying this trailing Lambda syntax, we moved
    // the function Lambda outside those parentheses which makes it look more like
    // a traditional function body. This often makes the Lambda more readable and easier to understand.
    printCalculatedValue(2, 2) { value1, value2 ->
        value1 + value2
    }


    //Because we stored basic formatter as a variable representing a function,
    // we can pass it in to print formatted name because the function types match.
    printFormattedName("Nate", "Ebel", basicFormatter)

    printFormattedName("Nate", "Ebel", fancyFormatter)

    printFormattedName("Nate", "Ebel") { first, last ->
        "$last, $first"
    }
}