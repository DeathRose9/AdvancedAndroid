package ca.elina.a9_twowaydatabindingintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ca.elina.a9_twowaydatabindingintroduction.databinding.ActivityMainBinding

// So far all the projects we have done use one way data binding.
// We learnt how to bind an object to a user interface.
// And we attached or bound UI elements to the properties of that object.
// By using live data with data binding, we wrote codes to update the UI automatically
// when the values of the object changes.
// Now, we are going to work with two way data binding.
// We will be able to write codes to change the values of associated object when the values of the UI changes.
// With two way data binding, when the value of the object changes, the UI changes,
// and when the UI changes, the value in the object changes.
// Changes update automatically to both ways.

// Step 1 - do all steps to enable Data Binding
// Step 2 - add required dependencies to use View Model and Live Data
// Step 3 - synchronise all
// Step 4 - create a new Kotlin class MainActivityViewModel.kt which should extend ViewModel class

class MainActivity : AppCompatActivity() {

    // Step 7 -  go to xml file and define a reference variable for the MainActivityViewModel class.
    // Name it as viewModel object type of MainActivityViewModel
    //     <data>
    //
    //        <variable
    //            name="viewModel"
    //            type="ca.elina.a9_twowaydatabindingintroduction.MainActivityViewModel" />
    //    </data>

    // Step 8 - bind the value of userName MutableLiveData to the TextView by writing
    // android:text="@{viewModel.userName}"

    // Step 9 - defining a data binding object
    private lateinit var binding: ActivityMainBinding

    // Step 11 - define a reference variable for the ViewModel
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Step 10 - replace setContentView function calling binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Step 12 - construct ViewModel
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // Step 13 - we need to assign this constructed view model object to the view model object we defined for the layout file.
        // We used the same name viewModel in the layout file.
        binding.viewModel = viewModel

        // Step 14 - Since we are using livedata with data binding, we need to set this activity as the lifecycle owner
        binding.lifecycleOwner = this
        // After step #14 if we run the app, we will see the initial userName we assigned in View Model

        // Step 15 in xml file add EditText with android:text="@{viewModel.userName}"
        // If we run the app again, we will see the same username in both EdtText and TextView
        // Because we "binded" the same username to both of them
        // If we type new name in EditText, the name of ET will change, but TV will remain unchanged
        // The reason of it is, one way data binding allows us to update the UI from the "binded"  object.
        // But it does’t allow us to update the "binded" object from the layout.

        // How use two-way data binding in order we see updated TV when we change ET
        // Step 16 - add equal sign between @ and {  in ET like this : android:text="@={viewModel.userName}"
        // Now when you type in ET it is displayed in TV
    }
}
// So that’s how two way data binding works.
// Since we are using two way data binding, whenever we are typing text on the ET,
// that text input will be assigned to the userName live data’s value in the view model object.
// Since that userName live data is "binded" to the TV, value of the TV  will also update at the same time.