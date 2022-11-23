package com.bestemorgul.coffeeapp.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bestemorgul.coffeeapp.data.model.CoffeeTypes

class DetailViewModelFactory(
    private val coffeeTypes: CoffeeTypes,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(coffeeTypes, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}