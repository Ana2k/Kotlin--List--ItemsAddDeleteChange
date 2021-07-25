package com.example.recyclereviewplaylistyt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding

class ExampleItem: Fragment() {
    private var _binding: ExampleItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var mImageView: ImageView
    private lateinit var mTextView1: TextView
    private lateinit var mTextView2: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = ExampleItemBinding.inflate(inflater, container, false)
        mImageView = binding.imageView
        mTextView1 = binding.textViewFirst
        mTextView2 = binding.textViewSecond
        return binding.root
    }

    companion object{
        fun newInstance() = ExampleItem()
    }
}