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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        // Step 17.3 - construct data binding object
        return binding.root
    }


}