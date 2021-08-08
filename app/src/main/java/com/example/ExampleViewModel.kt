package com.example

import android.app.Application
import android.app.ApplicationExitInfo
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclereviewplaylistyt.R
import timber.log.Timber
import java.lang.Math.random
import kotlin.math.min
import kotlin.math.roundToLong

class ExampleViewModel(val context: Context) : ViewModel() {

    //all working code shifted to here from mainActvity
    //context should pass
    //application can pass-- accesses the inner android workings

    //T Mutable Data and LiveData changes see
    //Mutable Live DAta -- as LiveData cannot be private?
    private var _mExampleList = MutableLiveData<ArrayList<ExampleItem>>()
    val mExampleList: LiveData<ArrayList<ExampleItem>> get() = _mExampleList
    var id: Long  = (random()).toLong()

    init{
        createExampleList()
    }

    //1
    private fun createExampleList() {

        var sample = ArrayList<ExampleItem>()
        //it was showing an error on trying for _mExampleList straight and arrayOf is usually used here insteadd.

        sample.add(ExampleItem(R.drawable.ic_android, "Line1", "Line2",id))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line3", "Line4",id+1))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line5", "Line6",id+2))
        //others
        sample.add(ExampleItem(R.drawable.ic_android, "Line 7", "Line 8",id+3))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 9", "Line 10",id+4))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 11", "Line 12",id+5))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 13", "Line 14",id+6))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 15", "Line 16",id+7))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 17", "Line 18",id+8))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 19", "Line 20",id+9))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 21", "Line 22",id+10))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 23", "Line 24",id+11))
        sample.add(ExampleItem(R.drawable.ic_android, "Line 25", "Line 26",id+12))
        sample.add(ExampleItem(R.drawable.ic_audio, "Line 27", "Line 28",id+13))
        sample.add(ExampleItem(R.drawable.ic_sun, "Line 29", "Line 30",id+14))

        _mExampleList.value = sample
    }


    fun removeItem(position: Int) {
        //removing the item from given position
        //came here from adapter
        //by default adding, android icon only
        var listItem = _mExampleList.value
        //just add inside sample the update _mExampleList.value= sample
        if (position< _mExampleList.value?.size as Int && position>=0) {
            listItem?.removeAt(position)
            toast("Removed Item at $position")
//            var sample = ArrayList<ExampleItem>()
//            val n = _mExampleList.value?.size as Int
//            for (i in 0..n - 1) {
//                if (i != position) {
//                    sample.add(_mExampleList.value?.get(i) as ExampleItem)
//                }
//            }-- atm code
            _mExampleList.value = listItem
        }
        else{
            toast("Enter valid position between 0 and current list size.")
        }


    }


    fun insertItem(position: Int) {
        //by default adding, android icon only
        var listItem = _mExampleList.value
        //just add inside sample the update _mExampleList.value= sample
        if (position< listItem?.size as Int && position>=0) {
            id= (id+random()+15).roundToLong()
            listItem.add(position,
                ExampleItem(R.drawable.ic_audio, "New item at $position", "This is line2",id))
            _mExampleList.value = listItem
            toast("Inserted Item at $position")
        }else{
            toast("Enter valid position between 0 and current list size.")
        }
    }
    fun onDeleteItemClicked(id: Long){
        toast("You clicked $id for removal")
        //now take the id and go to the one with the id???
        //take thier position and send it to removeItem(position)
        //but  how to extract the position if id is given?
        //do we need to do this or is thier a better way?
        //i have a hunch there is a better way
        Timber.d(_mExampleList.value.toString())
        var size = _mExampleList.value?.size
        for(i in 0..size!!){
            if id==item
        }

    }

    fun changeItem(position: Int, s: String) {
        Timber.tag("Hel").d(_mExampleList.value?.get(position).toString())
        var currItem = _mExampleList.value
        currItem?.get(position)?.changeText1(s)
        //called dataclass function specified and changed its text
        //update the _mExampleList.value.
        _mExampleList.value = currItem
        toast("Item no $position was clicked!")
        Timber.tag("Hel").d(_mExampleList.value?.get(position).toString())
    }

    fun toast(msg: String) {
        Toast.makeText(context,
            msg,
            Toast.LENGTH_SHORT).show()
        //https://stackoverflow.com/questions/36826004/how-do-you-display-a-toast-using-kotlin-on-android
        //for toast making
    }



}