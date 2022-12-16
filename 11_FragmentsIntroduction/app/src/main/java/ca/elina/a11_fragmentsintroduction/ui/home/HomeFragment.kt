package ca.elina.a11_fragmentsintroduction.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ca.elina.a11_fragmentsintroduction.databinding.FragmentHomeBinding
// Sub activity component called fragment.
// A fragment represents a reusable portion of the app's UI.
// It has many similarities to an activity.
// A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events.
// But fragments cannot live on their own.
// They must be hosted by an activity or another fragment.
// There can be more than one fragments in an activity.
// Fragments represent multiple screens inside an activity.

// Like Activity Fragment also has a lifecycle.
// Fragment lifecycle has additional callback functions than activity lifecycle.
// Such as:
// onCreateView()
// onViewCreated()
// onViewStateRestored()
// onSavedInstanceState() and
// onDestroyView()

// These additional steps are related to creating and destroying the view.

// We can create android applications without using any fragments.
// But, to provide a better UI, we need to use fragments.

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}