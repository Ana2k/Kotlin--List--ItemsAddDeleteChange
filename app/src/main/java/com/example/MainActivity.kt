package com.example

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    //viewModel
    private var mViewModel: ExampleViewModel? = null

    //TODO() -- make a viewmodel object and call others via it.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        val viewModelFactory = ExampleViewModelFactory(this)

        mViewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(ExampleViewModel::class.java)
        //steps
        //0) populate example list
        //1) implement the buttons
        //2) insertitem and removeitem implement
        //3) implement the recycler view

        mExampleList = mViewModel?.mExampleList?.value as ArrayList<ExampleItem>
//had an error here earlier


        buildRecyclerView()
        setUpViewModelObservers()
        setButtons()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpViewModelObservers() {
        mViewModel?.mExampleList?.observe(this,{ observer ->
            mRecyclerView?.adapter = ExampleItemAdapter(this,mExampleList, mViewModel!!)
        })

    }//removeItem


    //2
    private fun setButtons() {
        mButtonInsert = _binding.buttonInsert
        mEditTextInsert = _binding.editTextInsert
        mEditTextRemove = _binding.editTextRemove
        mButtonRemove = _binding.buttonRemove

        //https://stackoverflow.com/questions/44301301/android-how-to-achieve-setonclicklistener-in-kotlin
        //to implement onClick in kotlin
        mButtonInsert.setOnClickListener {
            try {
                val position: Int = mEditTextInsert.text.toString().toInt()
                mViewModel?.insertItem(position)
            }
            catch (e: Exception){
                mViewModel?.toast("Enter non null value!")
            }
        }
//        mButtonRemove.setOnClickListener {
//            val position: Int = mEditTextRemove.text.toString().toInt()
//            if (position < mExampleList.size && position >= 0) {
//                removeItem(position)
//            } else toast()
//        }
    }



    //3 build recycler view
    private fun buildRecyclerView() {
        mRecyclerView = binding.recyclerView
        mRecyclerView?.setHasFixedSize(true)

        mRecyclerView?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mRecyclerView?.adapter = ExampleItemAdapter(this,mExampleList,mViewModel!!)
    }//mAdapter custom function to attatch mListener to listener is invoked so that our
        //adapter works as wished

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
