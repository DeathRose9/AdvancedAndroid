fun main() {
    // ----------------- For(forEach) loop -----------------
    for (i in 1..4) {
        println("No. $i")
    }

    var list = listOf("Java", "C#", "PHP", "Kotlin", "Python")

    for (element in list) {
        println(element)
    }

    for ((index, value) in list.withIndex()) {
        println("Element at $index is $value.")
    }

    list.forEach { element -> println(element) }
    list.forEachIndexed { index, element -> println("$index: $element") }

    // ----------------- While loop -----------------
    var x = 5
    while (x >= 0) {
        println(x)
        x--
    }
}