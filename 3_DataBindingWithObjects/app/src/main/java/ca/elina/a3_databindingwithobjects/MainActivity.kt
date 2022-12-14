package ca.elina.a3_databindingwithobjects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ca.elina.a3_databindingwithobjects.databinding.ActivityMainBinding

// -------- Binding Objects to the Layout --------
// In most of the cases we need to get data to our app from either data base or from an API.
// In both of those cases we are receiving data as objects.
// With data biding we can write codes to directly send objects to the layout.
// So, we can not only make our codes more readable, but also we can reduce the amount of codes
// we used to write in view controller classes such as Activities and Fragments.
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
/*
        // get the student object from getStudent function
        val student = getStudent()

        // bind student name and email to the view using data binding
        binding.nameText.text = student.name
        binding.emailText.text = student.email
*/

//        How to send this student object directly to the layout rather than sending
//        values of its properties separately to the views of the layout.
//        Ability to make a data class directly available to a view is a big advantage of using data binding.
//        Data binding allows us to do it through the binding object.
//        It makes our code more readable and maintainable.

//        To use a data class directly in the layout, we need to add a reference to it in the layout.
//  Step 1 - go to xml file
//        This is where we will create a reference to the data class. We create object references inside variable tags.
//        In the variable tag we give a name to the object as a value of name parameter, and we will provide
//        the fully qualified name of the class with its package name as a value of the type parameter.
//        So -  between the <layout> and <ConstraintLayout> tags add this code
//        <data>
//          <variable
//              name = "student"
//              type = "com.yourPackageName.YourProjectName.Student" />
//        </data>

//  Step 2 - we can refer to this newly created student object reference variable from views.
//      in the xml file
//      We need to add to TextView of student name this code - android:text="@{student.name}"
//      We also need to add to TextView of student email this code - android:text="@{student.email}"
//      So, this is how we are referring to the student object reference variable we just created
//      Now, Layout modifying part is done.

//  Step 3 - here in main activity we need to write codes to send the student object to the layout.
//      Data binding library has created a new property for the student variable we newly added.
//      Since we declared a new variable named student, data binding library has updated the binding object
//      by adding a new student variable. So, this is how we pass object to the layout directly

        binding.student = getStudent()

    }

    private fun getStudent(): Student {
        return Student(1, "Alex", "alex@gmail.com")
    }
}

//  So, this is how we directly pass an object to the layout and use it with data binding.
//  1. At the top of the xml layout file, we declared an object reference variable using a variable tag,
//  inside data tags. (<data><variable>...</data>)
//  2. We used that object reference variable to get values for the views. (android:text="@{student.email}")
//  3. In the main activity we wrote codes to pass the student object to the binding object of the layout. (binding.student = getStudent())