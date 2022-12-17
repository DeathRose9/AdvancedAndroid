package ca.elina.a12_navigationarchitecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ca.elina.a12_navigationarchitecturecomponents.databinding.ActivityMainBinding

// Note ******
// You can find navigation components dependencies from this link below:
// https://developer.android.com/jetpack/androidx/releases/navigation#declaring_dependencies

// Step 1 - add dependencies for Navigation in build.gradle (App)(add Google Maven repository to use Navigation)
// def nav_version = "2.1.0"
//     implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
//    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

// Step 2  - add safe args in build.gradle (Project) dependencies
//         def nav_version = "2.1.0"
//        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"

// Step 3 - add plugin before android{} in build.gradle (App) -> apply plugin: "androidx.navigation.safeargs.kotlin"

// Step 5 - add data binding in build.gradle (App)

// Step 6 - Synchronize all

// Step 7 - add <layout> tag as outermost tag to activity_main.xml file
class MainActivity : AppCompatActivity() {
    // Step 8.1 - construct data binding object
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Step 8.2 - construct data binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
// Step 9 - Create a Navigation Graph ********
// - select  app
// - right click
// - New
// - Android Resource File
// - type file name as nav_graph
// - select the Resource Type as Navigation
// - click OK

// Step 10 - host Navigation Graph
// Connect a host Navigation Navigation Graph connect to the other parts of the app through this host fragment
// To add a Navigation host fragment go to activity_main.xml file.
// - remove the TextView
// - add navHostFragment container and set constraints on it
// The name is androidx.navigation.fragment.NavHostFragment.
// Value of the defaultNavHost property has set to true
// Path of the navigation graph xml resource file has set as the value of the navGraph property
