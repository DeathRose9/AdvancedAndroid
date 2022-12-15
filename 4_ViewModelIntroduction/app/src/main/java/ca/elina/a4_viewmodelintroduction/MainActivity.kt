package ca.elina.a4_viewmodelintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ca.elina.a4_viewmodelintroduction.databinding.ActivityMainBinding

// Initial steps for this project
// Step 1 - enable data binding in build.gradle(app)
// Step 2 - wrap xml with <layout> tag and put three namespace declarations in it
// Step 3 - in xml add a TextView with the id count_text and a Button with the id button

//
class MainActivity : AppCompatActivity() {

    // Step 4 - Declare reference variable for the binding object
    private lateinit var binding: ActivityMainBinding

    // Step 6 - define count variable to hold integer value
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Step 5 - binding object using DataBindingUtil
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Step 7 - show the initial count value on the text view
        binding.countText.text = count.toString()

        // Step 8 - implement the on click listener of the button
        binding.button.setOnClickListener {

            // Step 9 - increase count
            count++

            // Step 10 - show the updated/increased count value on the text view
            binding.countText.text = count.toString()
        }
    }
}

// When we press on the “Click Here” Button, we can see that click count value appears on the text view.
// NOTE ******
// If we rotate this app, ew can see that click count value disappeared
// If we press the button, count will again start from the beginning.

// EXPLANATION ******
// When we are using an android app,and when a configuration change like screen rotation happens,
// app has to destroy and recreate the activity with new configurations. As a result of that,
// values created during the running period of the activity will also be destroyed.
// That’s why click count value started from the beginning after the rotation.

// In the Android application development process one of the most common things is
// to consider the configuration changes.
// EXAMPLE ******
// Every time a configuration change happens, app will have to call to the online REST API and
// download data again and again.
// So, a lot of data and system resources will be wasted unnecessarily.
// And since user has to wait until the completion of the download again and again, the app
// will provide a very bad user experience.

// View Model ******** => a model for a view
// The View Model architecture component introduced with Android Jetpack is the best solution for these problems.
// https://developer.android.com/jetpack
// It has designed to store and manage the UI-related data.
// We usually create one View Model for an activity or a fragment. Sometimes two or more activities or fragments
// can share one view model. View Model is created in the memory, when the activity is created.
// It lives until activity is cleared from the memory.
// Therefore view Model can hold values belonging to the activity.

// https://developer.android.com/topic/libraries/architecture/viewmodel#lifecycle
// As this diagram from the Google developer documentation shows -
// from the moment an app launches an activity to the moment it appears on the screen
// Activity has to pass three lifecycle states: create state, start state and resume state.
// Activity has to pass pause, stop and destroy states before it ends.
// During that period activity can recreate again and again,
// but view model instance will live in the memory holding activities data.