package com.anushka.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo2.databinding.ActivityMainBinding

// Step 1 - do all steps to enable data binding
// Step 2 - add required dependencies to use View model
// Step 3 - synchronise them
// Step 4 - create a new kotlin class MainActivityViewModel
class MainActivity : AppCompatActivity() {
    // Step 10 - Declare two object reference variable: for the data binding object and for the view model object
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Step 11 - create the ViewModel
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

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
}

// This is how we use a view model to store and manage user interface controller data.