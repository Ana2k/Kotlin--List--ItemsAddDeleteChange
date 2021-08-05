package com.example

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExampleViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((ExampleViewModel::class.java))) {
            return ExampleViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}