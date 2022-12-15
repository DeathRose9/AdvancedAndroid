package ca.elina.a6_viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

// NOTE ******
// We can always re use this boilerplate code by changing the name of the view model and parameters.

// To make this a view model factory, we should make this a subclass of view model factory class.
// So, we should extend the ViewModelProvider.Factory class.

class MainActivityViewModelFactory(private val startingTotal: Int) : ViewModelProvider.Factory {
    // Step 19 - override the create function of the factory class.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingTotal) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
    // This is pretty much, standard boilerplate code, we use for all view model factory classes.
}