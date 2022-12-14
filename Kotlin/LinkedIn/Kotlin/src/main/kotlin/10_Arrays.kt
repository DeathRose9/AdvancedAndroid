fun main() {
    // -------------- ARRAYS -----------------
    // An array is a collection of values, typically of the same type.

    // The array of function is smart enough to recognize
    // whether we are mixing nullable and non-null values.

    // array of int
    // the type of the array will be inferred to be an array of non-null int
    val ints = arrayOf(1, 2, 3, 4, 5)

    // the inferred type of the array will be nullable int.
    // The array of function is smart enough to recognize
    // whether we are mixing nullable and non-null values
    val nullableInts = arrayOf(1, 2, 3, 4, null)

    // If we want to create an array of some given size,
    // and initialize it with all null values, we can use array of nulls.
    // So this will let us hold nulls or ints.
    val nulls = arrayOfNulls<Int>(5)

    // we can call the array constructor, and
    // provide an initialization Lambda to define how each value should be initialized.
    val custom = Array(5) { index -> index }
    // So in this case, we'll create a variable here called custom, and
    // we will call the array constructor with 5 as the size of the array.
    // Then we will define the open and closed curly braces here to define our Lambda.
    // This Lambda is going to let us initialize the array however we want Within that Lambda,
    // it's going to pass us an integer value representing the index in the array.
    // So for us, with an array of size 5 we will get indexes zero through four,
    // and in this case, we just want to fill up the array with values zero through four,
    // so we will just return the index value itself and that'll be our entire Lambda here.
    // So this will initialize the array with 5 values from zero through four,
    // essentially creating the same array as we did in our very first example.

    val sizeOfArray = ints.size // this will return 5

    // to access values in an array we can use get and set methods on the array
    val getFirstValue = ints.get(0) // first index in any collection is zero
    ints.set(0, 99) // set the first value of that array to be 99
    // equivalent to get and set we can use []
    // that compiler provides us, which makes a little easier to read and quicker write
    val firstValue = ints[0]
    ints[0] = 99


    // Primitive type int VS complex type Integer
    // If we need an array of some primitive types such as int or short,
    // Kotlin provides additional array types specifically designed for
    // storing values as primitives, rather than storing them as their
    // larger complex object types. Now, why is this helpful?
    // It comes down to the size of each type a primitive int takes up
    // less memory than int the object. Most of the time we work with the complex type,
    // but if we know we will be working with an array of a primitive,
    // and we think that array might be rather large, we can take advantage of this
    // more efficient array.
    val primitiveInts = intArrayOf(1, 2, 3, 4, 5)
    // array of unsigned shorts
    val primitiveUShorts = ushortArrayOf(1u, 2u, 3u, 4u, 5u)


    // Iterate over items of array
    // Option 1 - use basic for loop
    for (i in 0 until ints.size) {
        println(ints[i])
    }

    // Option 2 - no counter
    for (element in ints) {
        println(element)
    }

    // Option 3 - functional forEach using Lambda
    ints.forEach { println(it) }
    // same but more readable
    ints.forEach { element -> println(element) }

    greetThings("Hey", arrayOf("Kotlin", "Programming"))
    greetThings("Hello", "Kotlin", "Programming", "LinkedIn")
}

// function that takes a variable number of arguments
// a function that takes  a single greeting of type string, and then
// prints out a variable number of greetings based on the arguments passed to it

// traditional way of creating the same function would be with Array
fun greetThingsWithArray(greeting: String, items: Array<Any>) {
    for (item in items) {
        println("$greeting $item")
    }
}
// So this works great, but it requires us to create a new instance of an array anytime we call our function.
// To simplify this, we can use the vararg modifier.
fun greetThings(greeting: String, vararg items: Any) {
    for (item in items) {
        println("$greeting $item")
    }
}

