package ca.elina.a6_viewmodelfactory

import androidx.lifecycle.ViewModel

// Step 5 - extend ViewModel
// Step 6 - import the class (it might do it by default while you type)

// Step 17 - add a constructor parameter  (startingTotal: Int) to get the starting total value
// In this custom view model class, we added an int value as a constructor parameter.
// We need it to be passed when we are constructing the view model in the factory class.
// So, we need to define this as a variable in the factory class.
class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    // Step 7 - define a variable named total that holds integer value
    private var total = 0

// Step 18 - create init{} -> assign the passed starting total value to the total variable
    init {
        total = startingTotal
    }



    // Create two functions to get and set values of the variable
    // Step 8 -  create a function getTotal() to return the total type Int
    fun getTotal(): Int {
        return total
    }

    // Step 9 -  create a function setTotal(input:Int) to return the total value of total + input after a button click.
    fun setTotal(input: Int) {
        // input value is added to the current total value
        total += input
    }
}