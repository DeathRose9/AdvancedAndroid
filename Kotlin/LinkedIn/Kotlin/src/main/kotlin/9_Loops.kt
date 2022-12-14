fun main() {
    var counter = 0

    // Do-While Loop
    do {
        println(counter)
        counter += 1
    } while (counter < 5)

    // For Loop
    for (i in 0 until 5) println(i) // 0 to 4, 5 not included
    for (i in 0 .. 5) println(i) // 0 to 5, 5 included - inclusive on both sides
    for (i in 10 downTo  0) println(i) // count down - inclusive on both sides
    for (i in 10 downTo 0 step 3) println(i) // increment our counter by 3 // 10, 7, 4, 1
}