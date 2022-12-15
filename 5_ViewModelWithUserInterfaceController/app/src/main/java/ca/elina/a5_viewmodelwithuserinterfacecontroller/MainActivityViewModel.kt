package ca.elina.a5_viewmodelwithuserinterfacecontroller

import androidx.lifecycle.ViewModel

// To make this new class, a child class of a ViewModel class
// we need to either extend ViewModel or AndroidViewModel.

// Step 5 - extend ViewModel
// Step 6 - import the class (it might do it by default while you type)

// If we have extended AndroidViewModel, instead of ViewModel, we would have
// an instance of application as a constructor parameter.
// It is very important, when we need to use the application context in the code of the view model.

class MainActivityViewModel : ViewModel() {
    // Step 7 - define count variable to hold integer value
    private var count = 0

    // Step 8 -  create a function to return the current click count of type Int
    fun getCurrentCount(): Int {
        return count
    }

    // Step 9 -  create a function to return the updated count value after a button click.
    fun getUpdatedCount(): Int {
        // increase the value by one for each button press
        return ++count
    }
}