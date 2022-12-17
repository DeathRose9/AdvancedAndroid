package ca.elina.a13_recyclerviewfundamentals

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Step 1 - in activity_main.xml delete TextView
// Step 2 - in activity_main.xml create RecyclerView widget and set constraints and id for it
class MainActivity : AppCompatActivity() {

    // Step 9 - create list of Fruit objects
    val fruitsList = listOf<Fruit>(
        Fruit("Mango", "Frida"),
        Fruit("Apple", "Amedeo"),
        Fruit("Banana", "Vincent"),
        Fruit("Guava", "Eva"),
        Fruit("Lemon", "Arno"),
        Fruit("Pear", "Tom"),
        Fruit("Orange", "John")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Step 3 - initialize the RecyclerView (RV)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        // Step 4 - set background color for RV
        recyclerView.setBackgroundColor(Color.YELLOW)

        // Step 5 - Set the layout manager (LinearLayoutManager) for RV
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Step 6 -  create adapter class MyRecyclerViewAdapter that extends RecyclerView.Adapter<MyViewHolder>()

        // Step 7 -  create a data class and name is as Fruit

        // Step 8 - create a template as list_item.xml layout file
        // - add margins and bg color
        // - set id as clListItem
        // - add one TextView with id tvName and with constraints

        // Step 10 -  Set the adapter for RV
        recyclerView.adapter = MyRecyclerViewAdapter(
            fruitsList,
        ) { selectedItem: Fruit -> // moved lambda argument out of parenthesis
            listItemClicked(selectedItem)
        }
    }

    // Step 11 - display Toast message on item click showing the supplier of the Fruit object
    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(
            this@MainActivity,
            "Supplier is : ${fruit.supplier}",
            Toast.LENGTH_LONG
        ).show()
    }
}