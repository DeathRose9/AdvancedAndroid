fun main() {
    val listOfStrings = arrayListOf("Gevorg", "John", "Armen", "Vera", "Arman")
    val listOfInts = arrayListOf(1, 12, 121, -8, 0, 2548, -21)
    val listOfStrings2 = arrayListOf("Vera", "Arman", "Gevorg")
    val listOfStrings3 = arrayListOf("Vera", "Arman", "Gevorg", null)
    val listOfDifferentTypes = arrayListOf(12, "Gevorg", true, "Vera", null)

    println("------------- filter ---------------------------")
    val newListOfStrings = listOfStrings.filter {
        it.startsWith("G")
    }
    val newListOfStrings2 = listOfStrings.filterIndexed { index, s ->
        index > 2 && s.contains("A")
    }
    val newListOfStrings3 = listOfStrings.filterNot {
        it.startsWith("G")
    }
    val newListOfDifTypes = listOfDifferentTypes.filterIsInstance<String>()

    println(newListOfStrings) // [Gevorg]
    println(newListOfStrings2) // [Arman]
    println(newListOfStrings3)
    println(newListOfDifTypes)

    println("------------- all, any, none ---------------------------")
    println(listOfStrings.all {
        it.endsWith("n") && it.length > 2
    })
    println(listOfDifferentTypes.any { it is Boolean })
    println(listOfStrings.any {
        it.endsWith("n") && it.length > 2
    })
    println(listOfStrings.none {
        it.endsWith("y") && it.length > 2
    })

    println("------------- contains, containsAll -------------------")
    println(listOfStrings.containsAll(listOfStrings2))
    println(listOfStrings.contains("Vera"))

    println("------------- map ----------------------------------")
    var lengthOfElementsOfStrings = listOfStrings.map {
        it.length // [6, 4, 5, 4, 5]
    }
    println(lengthOfElementsOfStrings)
//    println(listOfStrings.map { it.length }) // [6, 4, 5, 4, 5]
    println(listOfStrings.map {
        it + " - ${it.length}" // [Gevorg - 6, John - 4, Armen - 5, Vera - 4, Arman - 5]
    })
    println(listOfDifferentTypes.mapNotNull {
        if (it is String) it.length else null // [6, 4]
    })
    println(listOfStrings3.map {
        it?.length //[4, 5, 6, null]
    })
    println(listOfStrings3.mapNotNull {
        it?.length //[4, 5, 6]
    })

    println("------------- flatten  ----------------------------------")
    val myList = listOf(
        listOf(12, 21, 12),
        listOf(true, false),
        listOf("Anna", "John")
    )
    println(myList.flatten()) // [12, 21, 12, true, false, Anna, John]
    println(myList) // list has not been changed -> [[12, 21, 12], [true, false], [Anna, John]]

    println("------------- groupBy  ----------------------------------")
    val variable = myList.flatten().groupBy {
        it is String
    }
    println(variable[true])
    println(variable.values)
    println(myList.flatten().groupBy {
        it is String
    })

    println("------------- sorted, reversed, sortedDescending, shuffle-----------")
    println(listOfInts.sorted())
    println(listOfInts.reversed())
    println(listOfStrings.sorted())
    println(listOfStrings.sortedDescending())
    println(listOfStrings.shuffled())

    println("------------- aggregated ->min, max, average, sum, count ----------------------------------")
    println(listOfInts.minOrNull())
    println(listOfInts.maxOrNull())
    println(listOfInts.average())
    println(listOfInts.sum())
    println(listOfInts.sumOf {
        if (it > 0) it else 0
    })
    println(listOfInts.count {
        it > 0
    })

    println(listOfStrings.minOrNull())
    println(listOfStrings.maxOrNull())
    println(listOfStrings.count())
    println(listOfStrings.maxByOrNull {
        it.length
    })

    println("------------- plus ,minus, union, zip ------------------------------")
    println(listOfStrings.minus("Vera"))
    println(listOfStrings.minus(1))
    println(listOfStrings)
    println(listOfStrings.plus("Vera"))
    println(listOfStrings.union(listOfInts)) // VS flatten
    println(listOfStrings.zip(listOfInts)) // returns Pair (takes the min number of the lists)

    println("------------- Collection elements -> slice, take, takeLast, takeWhile, takeLastWhile, drop, chunk ------------")
    println(listOfInts.slice(1..6))
    println(listOfInts.slice(1 until 6))
    println(listOfInts.slice(1..6 step 2))
    println(listOfInts.slice(listOf(0, 4, 3)))
    println(listOfInts.take(3))// takes first three elements
    println(listOfInts.takeLast(3)) // takes last three elements
    println(listOfInts.takeWhile {
        it > 0
    })
    println(listOfInts.takeLastWhile {
        it < 0
    })
    println(listOfInts.drop(3))// drops first three elements
    println(listOfInts.chunked(2))// chunks the list into sublists / the opposite of flatten

    println("------------- elementAt, elementAtOrElse, elementAtOrNull, first, random ------------")
    println(listOfInts.elementAt(1))
    println(listOfInts.elementAtOrElse(11) {
        "There in no such element - $it" // There in no such element - 11
    })
    println(listOfInts.elementAtOrNull(11)) // returns null if there is no such element
    println(listOfInts.first {
        it > 0
    })
    println(listOfInts.random())// returns randomly an element from the list

}
