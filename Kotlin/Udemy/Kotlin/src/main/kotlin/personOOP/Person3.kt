package personOOP

import java.time.LocalDate

class Person3(name: String, age: Int) {
    var name: String
    var age: Int
    var birthYear:Int
    var currentYear = LocalDate.now().year

    init {
        println()
        println("Object(Person3) was created")
        this.name = name
        this.age = age
        this.birthYear = currentYear - age
    }

    fun getYearOfBirth() = currentYear - age

    fun greet() {
        println("Hello $name!")
    }
}