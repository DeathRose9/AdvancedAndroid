package ca.elina.a7_livedatafundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.elina.a7_livedatafundamentals.databinding.ActivityMainBinding

// With live data , we can write codes to observe the data in the view model from the activity or fragment.
// And if any change or update to those data happens, with LiveData we can write codes to automatically
// update the activity or fragment.
// LiveData is part of android jetpack architecture components.
// LiveData is a lifecycle-aware observable data holder class.
// In android we have 3 app components with lifecycles: activities, fragments and services.
// So, activities, fragments and services can be used as observers of LiveData objects.
// LiveData only updates observers in an active lifecycle state.
// This is very useful.
// When we are using Rx java - to avoid errors, we have to carefully write codes to dispose
// observers when activity, fragment or service become inactive.
// But with LiveData, we don’t need to worry about that.
// So, what are the benefits of using live data.
// 1. LiveData automatically updates the UI when app data changes.
// Therefore with live data we will always have up-to-date data.
// 2. With live data we don’t need to write codes to handle lifecycles manually.
// 3. Since, live data is aware of lifecycle status changes,
// they clean up themselves when their associated lifecycle is destroyed.
// Therefore no memory leaks or crashes will happen as a result of destroyed activities or fragments.
// 4. We can also use live data to share our app’s services between different components of the app.

// NOTE ***  - continue from the previous project, so copy all and follow the new steps
// Step 1 starts in  MainActivityViewModel
class MainActivity : AppCompatActivity() {
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelFactory = MainActivityViewModelFactory(125)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        // Here, we will write codes to observe the total value, which is now in MutableLiveData format.
        // Step 5 - delete ->  binding.resultTextView.text = viewModel.getTotal().toString() and write this...
        viewModel.total.observe(this, Observer {
            //  “it” represents int total value
            // Step 6 -  can write codes to show the total value in the text view.
            binding.resultTextView.text = it.toString()
        })

        binding.insertButton.setOnClickListener {
            viewModel.setTotal(binding.inputEditText.text.toString().toInt())

            // Step 7 - delete code below as livedata automatically updates the text view
//            binding.resultTextView.text = viewModel.getTotal().toString()
        }
    }

}
