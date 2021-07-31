package com.example

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class ExampleViewModelFactory(private val context: Context, private val application: Application, private val mRecyclerView:RecyclerView) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExampleViewModel::class.java)) {
            return ExampleViewModel(context, application, mRecyclerView) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}