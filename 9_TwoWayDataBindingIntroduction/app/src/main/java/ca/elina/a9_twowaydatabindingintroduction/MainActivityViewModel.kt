package ca.elina.a9_twowaydatabindingintroduction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    // Step 5 - define a MutableLiveData of type String named username.
    val userName = MutableLiveData<String>()

    // Step 6 - include an init block to assign an initial value to this user name.
    init {
        userName.value = "Frida"
    }
}