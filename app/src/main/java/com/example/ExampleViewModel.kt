package com.example

import android.app.Application
import android.app.ApplicationExitInfo
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclereviewplaylistyt.R
import kotlin.math.min

class ExampleViewModel(val context: Context) : ViewModel() {
    //TODO() -- add recyclerView to this

    //all working code shifted to here from mainActvity
    //context should pass
    //application can pass-- accesses the inner android workings

    //T Mutable Data and LiveData changes see
    //Mutable Live DAta -- as LiveData cannot be private?
    private var _mExampleList = MutableLiveData<ArrayList<ExampleItem>>()
    val mExampleList: LiveData<ArrayList<ExampleItem>> get() = _mExampleList

    init{
        createExampleList()
    }

    //1
    private fun createExampleList() {

        var sample = ArrayList<ExampleItem>()
        //it was showing an error on trying for _mExampleList straight and arrayOf is usually used here insteadd.

        sample.add(ExampleItem(R.drawable.ic_android, "Line1", "Line2"))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line3", "Line4"))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line5", "Line6"))
        //others
        sample.add(ExampleItem(R.drawable.ic_android, "Line 7", "Line 8"))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 9", "Line 10"))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 11", "Line 12"))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 13", "Line 14"))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 15", "Line 16"))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 17", "Line 18"))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 19", "Line 20"))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 21", "Line 22"))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 23", "Line 24"))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 25", "Line 26"))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 27", "Line 28"))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 29", "Line 30"))

        _mExampleList.value = sample
    }


    fun removeItem(position: Int) {
        //removing the item from given position
        //came here from adapter
        //by default adding, android icon only
        var listItem = _mExampleList.value
        //just add inside sample the update _mExampleList.value= sample
        if (position< listItem?.size as Int && position!=null && position>=0) {

        toast("Inserted Item at $position")
        }
    else{
        toast("Enter valid position between 0 and current list size.")
    }


    }


    fun insertItem(position: Int) {
        //by default adding, android icon only
        var listItem = _mExampleList.value
        //just add inside sample the update _mExampleList.value= sample
        if (position< listItem?.size as Int && position!=null && position>=0) {
            listItem.add(position,
                ExampleItem(R.drawable.ic_audio, "New item at $position", "This is line2"))
            _mExampleList.value = listItem
            toast("Inserted Item at $position")
        }else{
            toast("Enter valid position between 0 and current list size.")
        }
    }

//    fun changeItem(position: Int, s: String) {
//        _mExampleList.value?.get(position)?.changeText1(s)
//        //called dataclass function specified and changed its text
//        mAdapter?.notifyItemChanged(position)
//    }

    fun toast(msg: String) {
        Toast.makeText(context,
            msg,
            Toast.LENGTH_LONG).show()
        //https://stackoverflow.com/questions/36826004/how-do-you-display-a-toast-using-kotlin-on-android
        //for toast making
    }



}