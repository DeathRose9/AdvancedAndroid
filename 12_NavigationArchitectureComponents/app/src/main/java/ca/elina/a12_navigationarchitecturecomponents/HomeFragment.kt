package ca.elina.a12_navigationarchitecturecomponents

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import ca.elina.a12_navigationarchitecturecomponents.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    // Step 17.1 - construct data binding object
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Step 17.2 - construct data binding object
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
/*
        // Step 26 -
        // use nav controller object to navigate to the second fragment
        binding.button.setOnClickListener {
            // Here view is represented by 'it'
            // pass the action id to navigate function as an argument
            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
        }
*/
        // Step 27 - Transform data between destinations using Bundle
        // use nav controller object to navigate to the second fragment
        binding.button.setOnClickListener {
            // Step 29 - add validation to the EditText (add if-else block)
            if (!TextUtils.isEmpty(binding.editText.text.toString())) {
                // Get the value from the EditText with id of editText
                val bundle = bundleOf("user_input" to binding.editText.text.toString())

                // Here view is represented by 'it'
                // pass the action id to navigate function as first argument
                // pass that bundle as the second argument of the navigate function
                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            } else {
                Toast.makeText(activity, "Please insert your name", Toast.LENGTH_LONG).show()
            }
        }

        // Step 17.3 - construct data binding object
        return binding.root
    }
}
// Step 28 is in SecondFragment.kt

// Note ********
// The best practise is using a view model and get the data from the view model.
// But Android Navigation architecture component allows us to pass data.