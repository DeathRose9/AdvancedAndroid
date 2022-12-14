package ca.elina.a2_objectdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ca.elina.a2_objectdatabinding.databinding.ActivityMainBinding

// When we are using data binding, we create a binding object that contains a reference to each view of a layout.
// Once a binding object has been created, all the components of the app can access the views, and other
// data, through the binding object.
// Benefit 1:
// This way, the android system do not need to go through the view hierarchy again and again, searching for
// views all the time.
// In that way, data binding improves the performance of our app a lot.
// Benefit 2:
// Another benefit of data binding is that with data binding we can eliminate findViewById.
// Data binding makes our codes concise, easier to read and maintain.
// Benefit 3:
// This data binding object creation happens in the compile time. Therefore if there is any error, we can
// recognize it during the compile time. So there will be no view related
// errors at runtime when the user is interacting with the app.

// Step 1 - go to build.gradle (app) and enable data binding
// - Open app level build.gradle file
// - Inside Android section write dataBinding {enabled = true }
// - Synchronize by clicking on sync
// - Now, gradle will download dataBinding library for our project

// Step 2 - go to activity_main.xml
// In order to generate a binding  class for a xml layout
// we need to wrap the layout with <layout></layout> tags.
// So, wrap activity_main.xml code with layout tags. --> <layout> xml code </layout>

// Step 3 - in activity_main.xml
// In Android, the namespace declarations for a layout must be in the outermost tag.
// So, cut the namespace declarations and paste them inside the layout tag.
// namespace declarations are:
// xmlns:android="http://schemas.android.com/apk/res/android"
// xmlns:app="http://schemas.android.com/apk/res-auto"
// xmlns:tools="http://schemas.android.com/tools"

// ActivityMainBinding - now is a data binding object
// The name of the layout we wrapped with layout tags is activity_main. Using that, android data binding library
// will create a binding object with the name of ActivityMainBinding. Data binding library takes the
// name of the xml layout, makes first letter of each name capital, removes underscore(s) and adds Binding to the end.
// This is how, data binding library gives the name to a data binding object -> activity_main => ActivityMainBinding
class MainActivity : AppCompatActivity() {
    // Step 4 - declare a reference variable for the binding object
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Step 5 - delete setContentView(R.layout.activity_main)
        // This setContentView function helps to render our layout on the screen.
        // Based on the value given by the user in the xml layout file,
        // views will be inflated and rendered according to the measurements of the screen.

        // With data binding we do not need this function. Instead we are going to use
        // a binding object to get the same work done in a more efficient and effective way.
        // So, let’s replace it with the data binding object creation code.

        // Step 6 - Binding object using DataBindingUtil
        // We need to provide the activity and resource id here
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Our new data binding object has properties for each of these views in the xml layout file.
        // Property names will be created removing underscores, using the camel case like this:
        // greeting_text_view -> greetingTextView, name_edit_text -> nameEditText, submit_button -> submitButton

        // Step 8 - We can Onclick to submitButton ("@+id/submit_button" in xml)
        binding.submitButton.setOnClickListener {
            displayGreeting()
        }
    }

    // Step 7 - let’s use binding object in our code.
    private fun displayGreeting() {
       // binding.greetingTextView.text = "Hello!" + binding.nameEditText.text;

        //use Kotlin’s "apply" scoping function to reduce the repetition of the name of data binding
        binding.apply {
            greetingTextView.text = "Hello! " + nameEditText.text
        }
    }
}
// So...
// 1. First of all we need to enable data binding in the app level build.gradle file.
// 2. After that we need to wrap the xml layout file with layout tags.
// 3. Then, we should construct a data binding object in the activity.
// 4. Finally, we can use that data binding object to directly call to views without using findViewById.