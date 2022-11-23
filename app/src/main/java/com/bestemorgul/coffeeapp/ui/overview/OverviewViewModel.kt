package com.bestemorgul.coffeeapp.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bestemorgul.coffeeapp.data.model.CoffeeTypes
import com.bestemorgul.coffeeapp.data.network.CoffeeApi
import com.bestemorgul.coffeeapp.data.network.CoffeeApiService
import kotlinx.coroutines.launch


enum class CoffeeApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<CoffeeApiStatus>()
    val status: LiveData<CoffeeApiStatus>
        get() = _status

    private val _coffee = MutableLiveData<List<CoffeeTypes>>()
    val coffee: LiveData<List<CoffeeTypes>>
        get() = _coffee


    init {
        getIcedCoffeeTypes()
    }


     fun getHotCoffeeTypes() {
        viewModelScope.launch {

            _status.value = CoffeeApiStatus.LOADING
            try {
                _coffee.value = CoffeeApi.retrofitService.getHotCoffee()
                _status.value = CoffeeApiStatus.DONE
            }
            catch (e:Exception) {
                _status.value = CoffeeApiStatus.ERROR
                _coffee.value= ArrayList()

            }
        }
    }

      fun getIcedCoffeeTypes() {
        viewModelScope.launch {

            _status.value = CoffeeApiStatus.LOADING
            try{
                _coffee.value = CoffeeApi.retrofitService.getIcedCoffee()
                _status.value = CoffeeApiStatus.DONE
            }
            catch (e:Exception) {
                _status.value = CoffeeApiStatus.ERROR
                _coffee.value=ArrayList()
            }
        }
    }

}