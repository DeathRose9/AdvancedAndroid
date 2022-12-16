package ca.elina.a8_viewmodel_livedata_withdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.elina.a8_viewmodel_livedata_withdatabinding.databinding.ActivityMainBinding
// This is part 2
// We continue working with the previous project 8_ViewModel_LiveData_withDataBinding - Part 1, where
// we integrated view models with data binding

// In part 2 we will integrate LiveData with data binding:
// We are going to remove live data observer code part, instead we will use
// livedata as a data binding source for the data binding object in the xml layout file.

// step 1 - in xml file for the TextView use the “count” LiveData value as written below
//  android:text="@{String.valueOf(myViewModel.count)}"
// This is how we use a LiveData directly as the data-binding source
// without using the LiveData observer functions

// NOTE ******
// There is one special thing to do before we run this app to see the results.
// LiveData is always associated with the lifecycle of an activity or a service.
// So, we must provide the actual lifecycle owner to the view model object.
// In the MainActivity, we need to set the current activity as
// the lifecycle owner of the binding object. (includes Step 2 and 3)
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.myViewModel = viewModel

        // Step 2 -
        binding.lifecycleOwner = this

        // Step 3 - delete the observer part
//        viewModel.count.observe(this, Observer { binding.countText.text = it.toString() })

        // Step 4 - To provide more security to the data, encapsulate it. Go to MainActivityViewModel
        //  and make variables private and create a public live data variable.
        // ALso change count to countData in xml file
    }
}
// So, this is how we use LiveData directly with data binding.
// 1. We use them on the views using their names and
// 2. We have to assign the lifecycle owner to the data binding object.
