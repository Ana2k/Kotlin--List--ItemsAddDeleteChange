package com.example

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ktx.BuildConfig
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.databinding.ActivityMainBinding
import timber.log.Timber


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

    //viewModel
    private var mViewModel: ExampleViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

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
        setButtons()
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
            try {
                val position: Int = mEditTextInsert.text.toString().toInt()
                mViewModel?.insertItem(position)
            } catch (e: Exception) {
                mViewModel?.toast("Enter non null value!")
            }//to prevent null app crash
        }
        mButtonRemove.setOnClickListener {
            try {
                val position: Int = mEditTextRemove.text.toString().toInt()
                mViewModel?.removeItem(position)
            } catch (e: Exception) {
                mViewModel?.toast("Enter non null value!")
            }
        }


    }


    //1 build recycler view
    private fun buildRecyclerView() {//some error here only
        mRecyclerView = binding.recyclerView
        mRecyclerView?.setHasFixedSize(true)

        mRecyclerView?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = ExampleItemAdapter(ExampleItemListener { id ->
            mViewModel?.onDeleteItemClicked(id)
        },
            ExampleItemChangeTextListener { id ->
                mViewModel?.changeItem(id)
            }
        )//accepts a clickListener as a param
        //observer of adapter lambda
        mRecyclerView?.adapter = adapter

        mViewModel?.mExampleList?.observe(this, Observer {
            adapter.submitList(it)
        })


    }//mAdapter custom function to attatch mListener to listener is invoked so that our
    //adapter works as wished

}