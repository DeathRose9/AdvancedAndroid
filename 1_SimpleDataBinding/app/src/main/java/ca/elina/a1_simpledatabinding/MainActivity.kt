package ca.elina.a1_simpledatabinding

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Step 2
        val button = findViewById<Button>(R.id.submit_button)

        // Step 3
        button.setOnClickListener {
            displayGreeting()
        }
    }

    // Here, inside this displayGreetings function, we have written codes to get the TextView and
    // EditText using findViewById() function to obtain references to views.
    // This app will display a greeting message on the TextView including the name inserted by the user.
    // Every time we use the findViewById() function to get reference to a view, Android system has to go through
    // the view hierarchy and find it at runtime. In a larger android application,
    // there can be many layouts and hundreds of views.
    // Therefore, going through the view hierarchy again and again at runtime is not a good idea.
    // It reduces the performance of larger android applications.

    // Step 1
    private fun displayGreeting() {
        val messageView = findViewById<TextView>(R.id.greeting_text_view)
        val nameText = findViewById<EditText>(R.id.name_edit_text)

        messageView.text = "Hello! " + nameText.text
    }
}