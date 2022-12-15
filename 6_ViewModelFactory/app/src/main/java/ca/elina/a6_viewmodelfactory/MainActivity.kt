package ca.elina.a6_viewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ca.elina.a6_viewmodelfactory.databinding.ActivityMainBinding

// Step 1 - do all steps to enable data binding
// Step 2 - add required dependencies to use View model
// Step 3 - synchronise them
// Step 4 - create a new kotlin class MainActivityViewModel
class MainActivity : AppCompatActivity() {
    // Step 20 - define a reference variable for the ViewModelFactory
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    // Step 10 - Declare two object reference variable: for the data binding object and for the view model object
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Step 21 - Create a factory instance and pass it as the second argument of the ViewModelProvider
        viewModelFactory = MainActivityViewModelFactory(125)

        // Step 11 - create the ViewModel
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        // Step 12 - invoke getTotal() functions, using this viewModel and set to resultTextView text
        binding.resultTextView.text = viewModel.getTotal().toString()

        // Step 13 set setOnClickListener on insertButton
        binding.insertButton.setOnClickListener {

            // Step 14 - get value from edit text, convert to Int and invoke function setTotal(input: Int) using viewModel
            viewModel.setTotal(binding.inputEditText.text.toString().toInt())

            //Step 15 - set text to resultTextView by invoking function getTotal() using viewModel
            binding.resultTextView.text = viewModel.getTotal().toString()
        }
    }

    // If we need to pass a value for the starting total as a constructor parameter to this ViewModel ->
    // To do such a thing, to create a custom ViewModel, we need to get support from a ViewModel factory class.
    // So...
    // Step 16 - create a new kotlin class MainActivityViewModelFactory which extends ViewModelProvider.Factory
}

//  We use a view model factory when we need to use custom view models with constructor parameters.
// To do that we need to:
// 1. create a new factory class which extends ViewModelProvider.Factory
// ( We can always re use this boilerplate code by changing the name of the view model and parameters.)
// 2. In the activity, we need to create an instance of it and
// 3. pass it as the second argument of the view model provider’s of function.

// So, this is how we use a factory class to construct custom view models.