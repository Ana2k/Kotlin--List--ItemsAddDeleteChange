package com.example

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding

class ExampleViewHolder(private val binding: ExampleItemBinding,private val viewModel: ExampleViewModel) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: ExampleItem,position: Int) {
        binding.textViewFirst.text = item.text1
        binding.textViewSecond.text = item.text2
        binding.imageView.setImageResource(item.imageResource)
        binding.imageDelete.setOnClickListener {
            Log.d("Lord Krishna", "Item removal button clicked")
            viewModel.removeItem(position)
        }//a kind of experimentation
        binding.listItem.setOnClickListener{
            viewModel.changeItem(position,"Clicked")
        }
    }
}