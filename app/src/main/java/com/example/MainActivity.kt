package com.example

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.R
import com.example.recyclereviewplaylistyt.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //the ArrayList
    private lateinit var mExampleList: ArrayList<ExampleItem>
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    //is it better to declare the layout variable with type and then assign it in onCreate or
    //call it everytime when we require it?
    private lateinit var mEditTextInsert: EditText
    private lateinit var mEditTextRemove: EditText
    private lateinit var mButtonInsert: Button
    private lateinit var mButtonRemove: Button

    //recyclerview vars
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: ExampleItemAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
        //steps
        //0) populate example list
        //1) implement the buttons
        //2) insertitem and removeitem implement
        //3) implement the recycler view
        createExampleList()
        setButtons()
        buildRecyclerView()
    }

    //1
    private fun createExampleList() {
        mExampleList = ArrayList()
//        val mExampleItem: ExampleItem = ExampleItem(R.drawable.ic_android,"Lineretstt","Line2Tesrt")
//        mExampleList.add(mExampleItem)
        mExampleList.add(ExampleItem(R.drawable.ic_android, "Line1", "Line2"))
        mExampleList.add(ExampleItem(R.drawable.ic_audio, "Line3", "Line4"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Line5", "Line6"))
        //others
        mExampleList.add(ExampleItem(R.drawable.ic_android, "Line 7", "Line 8"))
        mExampleList.add(ExampleItem(R.drawable.ic_audio, "Line 9", "Line 10"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Line 11", "Line 12"))
        mExampleList.add(ExampleItem(R.drawable.ic_android, "Line 13", "Line 14"))
        mExampleList.add(ExampleItem(R.drawable.ic_audio, "Line 15", "Line 16"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Line 17", "Line 18"))
        mExampleList.add(ExampleItem(R.drawable.ic_android, "Line 19", "Line 20"))
        mExampleList.add(ExampleItem(R.drawable.ic_audio, "Line 21", "Line 22"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Line 23", "Line 24"))
        mExampleList.add(ExampleItem(R.drawable.ic_android, "Line 25", "Line 26"))
        mExampleList.add(ExampleItem(R.drawable.ic_audio, "Line 27", "Line 28"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Line 29", "Line 30"))
    }

    //2
    private fun setButtons() {
        mButtonInsert = _binding.buttonInsert
        mEditTextInsert = _binding.editTextInsert
        mEditTextRemove = _binding.editTextRemove
        mButtonRemove = _binding.buttonRemove

        //https://stackoverflow.com/questions/44301301/android-how-to-achieve-setonclicklistener-in-kotlin
        //to implement onClick in kotlin
        mButtonInsert.setOnClickListener {
            val position: Int = mEditTextInsert.text.toString().toInt()
            if (position < mExampleList.size && position >= 0) {
                insertItem(position)
            } else toast()
        }
        mButtonRemove.setOnClickListener {
            val position: Int = mEditTextRemove.text.toString().toInt()
            if (position < mExampleList.size && position >= 0) {
                removeItem(position)
            } else toast()
        }
    }

    private fun toast() {
        Toast.makeText(this@MainActivity,
            "Enter valid position between 0 and current list size.",
            Toast.LENGTH_LONG).show()
        //https://stackoverflow.com/questions/36826004/how-do-you-display-a-toast-using-kotlin-on-android
        //for toast making
    }


    private fun removeItem(position: Int) {
        //removing the item from given position
        //came here from adapter
        mExampleList.removeAt(position)
        mAdapter?.notifyItemRemoved(position)
    }


    private fun insertItem(position: Int) {
        //by default adding, android icon only
        mExampleList.add(position,
            ExampleItem(R.drawable.ic_audio, "New item at $position", "This is line2"))
        mAdapter?.notifyItemInserted(position)
    }





    //3 build recycler view
    private fun buildRecyclerView() {
        mRecyclerView = binding.recyclerView
        mRecyclerView?.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        mAdapter = ExampleItemAdapter(mExampleList)

        mRecyclerView?.layoutManager = mLayoutManager
        mRecyclerView?.adapter = mAdapter

        mAdapter?.setOnItemClickListener(object : ExampleItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                changeItem(position, "Clicked")
                //mExampleList.get(position).changeText1("Clicked");
            }

            override fun onDeleteClick(position: Int) {
                removeItem(position)
            }
        })//mAdapter custom function to attatch mListener to listener is invoked so that our
        //adapter works as wished

    }

    private fun changeItem(position: Int, s: String) {
        mExampleList[position].changeText1(s)
        //called dataclass function specified and changed its text
        mAdapter?.notifyItemChanged(position)
    }


    //onCreate-> 1)createExampleList-> 2) setButtons()-> 3)buildRecyclerView()
    //1) createExampleList--> in global variable of arraylist, put the lists. add the values--
    //--> for this already created ExampleItemViewModel data class

    //2)setButtons-- insert, remove buttons and editTextz--> calls insertItem(),removeItem(),onClick with position of list element
    //insertItem() and removeItem()-->
    //in mExampleList.add and mExampleList.remove along with mAdapter.notifyItemInserted or .notifyItemRemoved with position
    //
    //For understanding the mAdapter and its class The adapter--->go to ExampleItemAdapter .
    //onItemClick and OnDeleteClick mentioned in interface are here in mainActivity--inside RecyclerView

    //In buildRecyclerView
    //assign data to member variables to adapter, recyclerView and layoutManager
    //call a custom setOnItemClickListener() created in Adapter class
    //to do an itemClick and onItemClick-- change and remove the items-- we have a custom function -- changeItem() for the same
    // PS:
    //  setHasfixedSize(true)-- overflow link: https://stackoverflow.com/questions/28709220/understanding-recyclerview-sethasfixedsize
}
