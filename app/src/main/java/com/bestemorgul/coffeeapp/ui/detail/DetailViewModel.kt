package com.bestemorgul.coffeeapp.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bestemorgul.coffeeapp.data.model.CoffeeTypes

class DetailViewModel (coffeeTypes: CoffeeTypes, app: Application) : AndroidViewModel(app) {

    private val _selectedCoffee = MutableLiveData<CoffeeTypes>()
    val selectedCoffee: LiveData<CoffeeTypes>
        get() = _selectedCoffee

    init {
        _selectedCoffee.value = coffeeTypes
    }




}