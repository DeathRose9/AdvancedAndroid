package ca.elina.a8_viewmodel_livedata_withdatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var count = MutableLiveData<Int>()

    val countData : LiveData<Int>
        get() = count

    init {
        count.value = 0
    }

    fun updateCount(){
        count.value = (count.value)?.plus(1)
    }

}