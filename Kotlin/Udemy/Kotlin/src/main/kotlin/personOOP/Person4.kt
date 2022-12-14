package personOOP

import java.time.LocalDate

class Person4(val name: String, var age: Int) {

    init {
        println()
        println("Object(Person4) was created")
    }

    var currentYear = LocalDate.now().year
    fun getYearOfBirth() = currentYear - age

    fun greet() {
        println("Hello $name!")
    }
}