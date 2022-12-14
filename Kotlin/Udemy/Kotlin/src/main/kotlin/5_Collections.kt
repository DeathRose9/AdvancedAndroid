
fun main() {
    // Arrays and Lists are containers for elements, which are referred to as Collections
    // Arrays - elements cannot be added or deleted after, have fixed length
    // Lists - mutable lists' elements can be deleted or added, immutables cannot change the content
    // ArrayLists are mutable

    val array = arrayOf("Texas", "Iowa", "California")
    val array2 = arrayOf("Nevada", "Florida")

    val list = listOf("Orange", "Apple", "Banana")

    val states = array + array2

    val arraylist = arrayListOf( "Gogh", "Modigliani", "Frida")
    arraylist.add("Minas Avetisyan")
    arraylist.remove("Gogh")

    val mixedList = arrayOf("Text", 12, true, "MixedTypes", 0.8, 121L)

    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    numbers.set(8, 99) // set 8th element to the value of 99

    val str = mixedList[3].toString()

    var subList = arraylist.subList(1, 3) // includes 1, excludes 3, so -> 1,2
    var changed = subList.add("Saryan") // boolean true
    var removed = subList.remove("Frida") // boolean true
    var removed2 = arraylist.remove("Amedeo") // boolean false

    println(list)
    println(array.get(0)) // .get(index)
    println(arraylist + list)
    println(states.toList())
    println(states.size)
    println(states.contains("Texas")) // Boolean
    println(states.isEmpty()) // Boolean
    println(subList) //  arrayList for print does not need toList()
    println(changed)
    println(removed)
    println(removed2)
    println(mixedList.toList())
    println(mixedList[0])
    println(numbers.toList())
    println(str[6]) // 6th element of MixedTypes String (which are arrays of characters)
}