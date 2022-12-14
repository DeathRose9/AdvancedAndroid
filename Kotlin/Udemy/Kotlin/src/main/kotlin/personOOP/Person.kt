package personOOP

class Person {
    var name: String = "Sarah"
    var age: Int = 42

    fun speak() {
        println("Hello!")
    }

    fun greet(name: String) {
        println("Hello $name!")
    }

    fun getYearOfBirth(): Int {
        return 2021 - 42
    }

    fun getYearOfBirth2() = 2021 - age
}