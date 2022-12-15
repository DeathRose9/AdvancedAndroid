package com.anushka.viewmodeldemo2

import androidx.lifecycle.ViewModel

// Step 5 - extend ViewModel
// Step 6 - import the class (it might do it by default while you type)

class MainActivityViewModel : ViewModel() {
    // Step 7 - define a variable named total that holds integer value
    private var total = 0

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