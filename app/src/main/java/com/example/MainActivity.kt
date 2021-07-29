package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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
    private lateinit var mButtonInsert : Button
    private lateinit var mButtonRemove: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view  = _binding.root
        setContentView(view)
        //steps
        //1) create the example list-- the data class--check
        //2) implement the buttons
        //3) implement the recycler view

        mButtonInsert = _binding.buttonInsert
        mEditTextInsert = _binding.editTextInsert
        mEditTextRemove = _binding.editTextRemove
        mButtonRemove = _binding.buttonRemove

        //https://stackoverflow.com/questions/44301301/android-how-to-achieve-setonclicklistener-in-kotlin
        //to implement onClick in kotlin
        mButtonInsert.setOnClickListener { object: View.OnClickListener{
            override fun onClick(v: View?) {
                
            }
        }

        }
    }
}