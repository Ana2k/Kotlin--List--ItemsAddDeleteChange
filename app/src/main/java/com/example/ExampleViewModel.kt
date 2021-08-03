package com.example

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.R

class ExampleViewModel(
    val context: Context,
    application: Application,
    val mRecyclerView: RecyclerView
) :
    AndroidViewModel(application) {
    private var _mExampleList = MutableLiveData<ArrayList<ExampleItem>>()
    val mExampleList: LiveData<ArrayList<ExampleItem>>
        get() = _mExampleList

    init {
        createExampleList()
    }

    fun createExampleList() {
        var sample = ArrayList<ExampleItem>()
        sample.add(ExampleItem(R.drawable.ic_audio, "Line3", "Line4", 0L))
        sample.add(ExampleItem(R.drawable.ic_android, "Line1", "Line2", 1L))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line3", "Line4", 2L))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line5", "Line6", 3L))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 7", "Line 8", 4L))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 9", "Line 10", 5L))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 11", "Line 12", 6L))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 13", "Line 14", 7L))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 15", "Line 16", 8L))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 17", "Line 18", 9L))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 19", "Line 20", 10L))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 21", "Line 22", 11L))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 23", "Line 24", 12L))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 25", "Line 26", 13L))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 27", "Line 28", 14L))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 29", "Line 30", 15L))
        _mExampleList.value = sample
    }

    fun insertItem(position: Int) {
        if (position < _mExampleList.value?.size as Int && position >= 0) {
            _mExampleList.value?.add(
                position,
                ExampleItem(R.drawable.ic_audio, "New item at $position", "This is line2", 16L)
            )
        } else {
            toast("Enter valid position between 0 and current list size.")
        }
    }

    private fun toast(mssg: String) {
        Toast.makeText(
            context,
            mssg,
            Toast.LENGTH_LONG
        ).show()
    }

    fun onExampleDeleteClicked(id: Long) {
        Toast.makeText(context, "${id} has been clicked for removal", Toast.LENGTH_SHORT).show()
    }

    fun removeItem(position: Int) {
        if (position < _mExampleList.value?.size as Int && position >= 0) {
            var sample = ArrayList<ExampleItem>()
            val n = _mExampleList.value?.size as Int
            for (i in 0..n - 1) {
                if (i != position) {
                    sample.add(_mExampleList.value?.get(i) as ExampleItem)
                }
            }
            _mExampleList.value = sample
        } else {
            toast("Enter valid position between 0 and current list size.")
        }
    }
}