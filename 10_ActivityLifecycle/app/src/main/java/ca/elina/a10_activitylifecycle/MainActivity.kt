package ca.elina.a10_activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// When we are opening an Android application, system creates an instance of the launcher activity in the memory.
// In our current project launcher activity is the MainActivity.
// So, whenever we run this application or we install and open this application in a phone,
// the Android system will create an instance of this MainActivity.kt class in the memory.
// That can be considered as the birth of the MainActivity instance.
// Technically, it is called launch of the MainActivity instance.
// And that new activity instance will have to spend time in different lifecycle stages
// before it finally become dead or more technically shut down from the memory.
// Not only the launcher activity, but also all the activities and fragments of Android have lifecycles.
// You can find Android activity lifecycle diagram from the official documentation here…
// https://developer.android.com/guide/components/images/activity_lifecycle.png

// The Android system is doing these lifecycle changes to the activity instance,
// considering the user's and environment's requirements.
// As an example, if the user opens another app while using our app. Let's say user wants to take a call,
// then Android system must move current activity of our app to pause state and move the application to the background.
// After the user done with the phone call, system will take our app to foreground and transit the activity
// from paused state back to the resumed state.
// To recognise state transit, we can use a set of overridden lifecycle callback functions provided by the activity class.
// These callback functions allow the activity to know that the system is creating, stopping or resuming an activity or
// destroying the process in which the activity resides.
// You can use those functions to write codes, to perform a specific task required to a given change of state.
// It is very important for the smooth performance of our apps and that will make our apps more user friendly.
// As an example, in one activity of our app, we are displaying a video file to the user.
// Then think what will happen if a user clicks on the menu item and opens another activity.
// We should write codes to pause the video before open the new activity.
// We can use onPause callback function to do that.

class MainActivity : AppCompatActivity() {
    // When we launch an activity:
    // Firstly, it creates state. At that time Android system
    // will invoke activity instances onCreate() callback function.
    // In the onCreate() function we perform basic application startup logic.
    // That should happen only once for the entire life of the activity.
    // This is a mus- have function.
    // That's why when we create a new activity class Android Studio creates this function for us.
    // This is the onCreate overridden function of the MainActivity.
    // Overriding onCreate() function is compulsory.
    // You must have an onCreate() function in an activity.
    // It is the only compulsory lifecycle function.
    // All other lifecycle functions are optional.
    // We don't have to override them unless we need to use them.
    override fun onCreate(savedInstanceState: Bundle?) {
        // When we create an activity, we extend AppCompact activity class.
        // If we check the class hierarchy of it, AppCompact activity class extents, FragmentActivity, FragmentActivity extents ComponentActivity,  ComponentActivity extends the original Activity class, which has original lifecycle callback functions.
        // All the activities we create automatically extend these classes.
        // Read more here..
        // https://developer.android.com/reference/androidx/appcompat/app/AppCompatActivity

        // When the system creates an instance of one of the activities in the memory system also
        // creates instances of these parent classes.
        // If we haven't overridden an optional lifecycle function, like onStart() or onResume()
        // system will only invoke activity class's original function.
        // After the onCreate() method finishes execution, the activity enters to the started state and
        // the system calls the onStart() and onResume() in a quick succession.
        // The onStart() function of the activity class prepares the activity to enter the foreground and becomes interactive.
        // This is where, the app initializes the code that creates the user interface.
        // Then, during the resumed state, app comes to the foreground.
        // This is the state, in which the activity interacts with the user.
        // Now, we can call activity is running.
        // When that happen, onResumed() function will be called. Activity stays in the resumed state until something happens to take focus away from it.
        // What are the events that can happen to take the focus away from a running activity?
        // User Navigating to another activity.
        // User receiving a phone call.
        // Device Screen is turning off.
        // Or a screen rotation.
        // In those cases Activity will transit to paused state, and onPaused() function will be invoked.
        //If the activity returns to the resumed state from the paused state, the system once again calls onResumed() method.
        //So, if our app required something to initialize every time activity resumed, we should override the onResumed() function and add that code part there.

        //We may write codes inside onResumed() overridden function for tasks, like reconnecting with the server to load media files or to initialize the camera.
        //The system calls the onPaused() function and takes the activity to paused state
        //As soon as the user is leaving. Activity app is moving from foreground to the background.

        //We should use the unPaused() overridden function to pause or adjust operations that should not continue while the activity is in the paused state.
        //After the paused state, If the app is not moving to the resumed state, system may transit activity to the stopped state.
        //When that happen, Activity instance will be still there, in the memory, but UI will be destroyed.

        //If the user navigates back to an activity in a stopped state, system will have to invoke onReStart() and onStart() functions to create the user interface again.

        //This onDestroy() function is called, when the system destroys the activity.
        //This can happen when we programmatically invoke the finish() function to intentionally destroy the activity.
        //This can also happen, when the user makes a configuration change such as rotate the screen or change the language.
        //When that happen, system will temporarily destroy the activity and recreate it again invoking onCreate() function call.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MYTAG","MainActivity : OnCreate")
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""
        submitButton.setOnClickListener {
            enteredName = inputField.text.toString()
            if (enteredName == ""){
                offersButton.visibility = View.INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Please, enter your name!",
                    Toast.LENGTH_SHORT
                ).show()
            }else {
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = View.VISIBLE
            }
        }

        offersButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",enteredName)
            startActivity(intent)
        }
    }

    // We are going to overwrite all the lifecycle in both main and second activities with Log
    override fun onStart() {
        super.onStart()
        Log.i("MYTAG","MainActivity : OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG","MainActivity : OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG","MainActivity : OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG","MainActivity : OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG","MainActivity : OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG","MainActivity : OnRestart")
    }
}