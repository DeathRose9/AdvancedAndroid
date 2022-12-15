package ca.elina.a5_viewmodelwithuserinterfacecontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ca.elina.a5_viewmodelwithuserinterfacecontroller.databinding.ActivityMainBinding
// Step 1 - do all steps for data binding
// Step 2 - add dependency in app level build.gradle file for ViewModel and LiveData
//     def lifecycle_version = "2.6.0-alpha02"
//    // ViewModel
//    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
//    // LiveData
//    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
// Step 3 - synchronise it
// Step 4 - create a new kotlin class MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Step 10 - get an instance of ViewModel class with type of MainActivityViewModel
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Step 11 - create the ViewModel
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        // Now, we can invoke functions of ViewModel, using this viewModel instance.

        // Step 12 - invoke functions of ViewModel, using this viewModel
        binding.countText.text = viewModel.getCurrentCount().toString() // binding.countText.text = count.toString() -> previously
        binding.button.setOnClickListener {
            binding.countText.text = viewModel.getUpdatedCount().toString() // binding.countText.text = count.toString() -> previously
        }
    }
}
// To demonstrate a configuration change, which caused to destroy and recreate the activity,
// rotate this app!!!
// NOTICE ******
// This time we are getting the same count value we had before the rotation.
// Now as a result of our newly created view model object storing data
// while the view controller class destroying and re creating during the configuration change,
// we get the actual click count value.
// In previous example count started from 0 after rotation / configuration change.