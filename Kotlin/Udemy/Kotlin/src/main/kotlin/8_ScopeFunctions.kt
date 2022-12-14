// Scope functions: let, with, run, apply and also
fun main() {
    // ********************  let ********************
    val studentOne = Student(22, "Marcel")
    var varArrayList = mutableListOf(1, 2005, -8, 7456, 12, 45, 786, -456, 0)
    varArrayList.let {
        println(it)
        it.add(5)
        println(it)
        println(it.size)
        var x = ""
        it.forEach {
            x += "$it, "
        }
        print("The final result is: " + x.dropLast(2))
    }
    println()
    println(varArrayList)

    studentOne.let {
        if (it.age > 18) {
            println("${it.name} is eligible to be accepted")
        }
    }

    mult(8, 11).let {
        println(it)
        val num = it + 100
        println(num)
    }

    // same code but less clean and less verifiable
    val number = 100
    val multiple = mult(11, 8)
    println(multiple)
    println(number + multiple)

    // ********************  with ********************
    with(varArrayList) {
//        this.add(11)
        add(11) //same, but different syntax
    }
    println(varArrayList)


    // ********************  run ********************
    addInt(12, 21).run {
        var par = this.toString()
        println(par)
    }

    varArrayList.run {
        add(111)
    }
    studentOne.run {
        if (age > 18) {
            println("$name is eligible to be accepted")
        }
        studentOne
    }.let {
        it.name = "Phillip"
    }

    // ********************  apply ********************
    studentOne.apply {
        if (age > 20) {
            println("$name is eligible to be accepted")
        }
    }

    // ********************  also ********************
    studentOne.also {
        if (it.age > 18) {
            println("${it.name} is eligible to be accepted")
        }
    }
}

fun mult(x: Int, y: Int) = x * y
fun addInt(x: Int, y: Int) = x + y


class Student(var age: Int, var name: String) {

}