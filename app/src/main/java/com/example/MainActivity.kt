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
import com.example.recyclereviewplaylistyt.R
import com.example.recyclereviewplaylistyt.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //the ArrayList
//    private lateinit var mExampleList: ArrayList<ExampleItem>
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    //is it better to declare the layout variable with type and then assign it in onCreate or
    //call it everytime when we require it?
    private lateinit var mEditTextInsert: EditText
    private lateinit var mEditTextRemove: EditText
    private lateinit var mButtonInsert: Button
    private lateinit var mButtonRemove: Button

    private lateinit var mExampleList: ArrayList<ExampleItem>

    //recyclerview vars
    private lateinit var mRecyclerView: RecyclerView

    //    private var mAdapter: ExampleItemAdapter? = null
    private lateinit var exampleViewModel: ExampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        mExampleList = ArrayList<ExampleItem>()
        mRecyclerView = binding.recyclerView

        val application = requireNotNull(this).application
        val viewModelFactory = ExampleViewModelFactory(this, application, mRecyclerView)

        exampleViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(ExampleViewModel::class.java)
        mExampleList = exampleViewModel.mExampleList.value as ArrayList<ExampleItem>
        buildRecyclerView()
        setupViewModelObservers()
        setButtons()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupViewModelObservers() {
        exampleViewModel.mExampleList.observe(this, Observer { newExampleList ->
            val initialLength = mExampleList.size
            val finalLength = newExampleList.size
            mExampleList = newExampleList
            if (initialLength > finalLength) {
                mRecyclerView.adapter = ExampleItemAdapter(mExampleList, this, exampleViewModel)
            }
            mRecyclerView.adapter?.notifyDataSetChanged()
        })
    }


    private fun setButtons() {
        mButtonInsert = _binding.buttonInsert
        mEditTextInsert = _binding.editTextInsert
        mEditTextRemove = _binding.editTextRemove
        mButtonRemove = _binding.buttonRemove

        mButtonInsert.setOnClickListener {
            val position: Int = mEditTextInsert.text.toString().toInt()
            exampleViewModel.insertItem(position)
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

        mRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.adapter = ExampleItemAdapter(mExampleList, this, exampleViewModel)
    }

//    private fun changeItem(position: Int, s: String) {
//        mExampleList[position].changeText1(s)
//        //called dataclass function specified and changed its text
//        mAdapter?.notifyItemChanged(position)
//    }
}
