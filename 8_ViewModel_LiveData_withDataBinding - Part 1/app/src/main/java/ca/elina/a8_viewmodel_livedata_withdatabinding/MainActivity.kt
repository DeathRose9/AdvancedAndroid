package ca.elina.a8_viewmodel_livedata_withdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.elina.a8_viewmodel_livedata_withdatabinding.databinding.ActivityMainBinding

// Step 1 - do all steps to enable Data Binding
// Step 2 - add required dependencies to use View Model and Live Data
// Step 3 - synchronise all
// Step 4 - create ViewModel with mutable live data with a function of updateCount() and set it in Edit Text

// Next steps to be done:
// I. We are going to integrate data binding object directly to the view model object.
// II. We will use listener bindings for the button to invoke view model’s updateCount() function.
// III. We will learn how to use LiveData as a data-binding source, so
// we will be able to use LiveData directly in the xml layout without writing codes to
// observe them in the activity or fragment.

// Step 5 - go to xml file and add the view model as a data binding variable,
// name as myViewModel and the type is MainActivityViewModel as shown below...
//     <data>
//        <variable
//            name="myViewModel"
//            type="com.packageName.ProjectName.MainActivityViewModel" />
//    </data>

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // Step 6 - assign the view model object we created in xml (myViewModel), to the binding object
        binding.myViewModel = viewModel

        viewModel.count.observe(this, Observer {
            binding.countText.text = it.toString()
        })

        // Step 8 - remove this  binding.button.setOnClickListener code part
//        binding.button.setOnClickListener {
//            viewModel.updateCount()
//        }
    }
}
// how to use a listener binding for the onClick event
// Step 7 - go to xml file and in <Button> tag add ->  android:onClick="@{()->myViewModel.updateCount()}"
// This is the updateCount() function, we are going to invoke  this binding expression or this
// listener binding will execute when the button's onClick() event triggered by the user.
// To reduce the amount of code we have used a lambda expression.
// NOTE ******
// For this type of listener bindings, gradle version should be 2.0 or higher.