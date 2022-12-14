package personOOP
fun main() {
    val person = Person()
    println(person.name)
    println(person.age)

    person.name = "Peter"
    println(person.name)

    person.speak()
    person.greet("world")
    println(person.getYearOfBirth())
    println(person.getYearOfBirth2())

    val person2 = Person2("Jennie", 40)
    println(person2.name)
    println(person2.age)
    println(person2.birthyear)

    person2.name = "Frida"
    person2.age = 42
    println("${person2.name} is ${person2.age} y/o")

    val person3 = Person3("Amedeo", 38)
    println(person3.name)
    println(person3.age)
    person3.greet()
    println(person3.birthYear)
    println(person3.getYearOfBirth())

    val person4 = Person4("William", 22)
    println(person4.name)
    println(person4.age)
    person4.age = 36
    println("New age is: " + person4.age)
    println(person4.getYearOfBirth())
    person4.greet()
}