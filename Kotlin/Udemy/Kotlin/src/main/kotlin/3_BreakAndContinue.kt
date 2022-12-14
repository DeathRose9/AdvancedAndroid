fun main() {

    // break
    for (c in "Amedeo") {
        print(c)

        if (c == 'd') {
            break
        }
    }
    println()

    // continue
    for (c in "Amedeo") {

        if (c == 'e') {
            continue
        }
        print(c)
    }
    println()

    val list = listOf("Book", "Table", "Laptop")
    for (str in list) {
        if (!str.contains("o")) {
            continue //  it will skip "Table" as it does not contain "o"
        }
        println(str)
    }

    // Naming loops
    outerloop@ for (i in 1..10) {
        for (j in 1..10) {
            if (i - j == 5) {
                break@outerloop // works the same way with continue
            }
            println("$i - $j")
        }
    }

    // -------------- Challenge - loops -----------------
    /*
    * For this challenge, try to write a program that calculates the sum of all
    * numbers from 100 to 100,000 and prints out the result.*/

    var sum = 0L
    for (i in 100..100000) {
        sum += i
    }
    println("The sum is $sum") // The sum is 5000045050

    /*
    * Create an array list of your favorite book titles. Loop over this list and,
    * if the title contains the letter ‘e’, print each character of the name on a new line.*/

    val listOfBooks = arrayListOf("Bookabc", "Bookdef", "Bookefg", "Bookhij")
    for (book in listOfBooks) {
        if (book.contains('e')) {
            for (letter in book) {
                println(letter)
            }
        }
    }
}