package ca.elina.a13_recyclerviewfundamentals

// In Kotlin data classes are used to hold data or state.
// By default, these classes contains standard functionalities.
// We don't have to define getter and setter functions in these classes as we used to do in Java entity classes.
// Those standard functions are generated automatically.
// Kotlin data classes save our time to write boilerplate codes.

data class Fruit(val name: String, val supplier: String)
