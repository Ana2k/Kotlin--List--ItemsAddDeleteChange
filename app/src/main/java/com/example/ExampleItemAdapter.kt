package com.example

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.R
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding


class ExampleItemAdapter(
    private val mExampleList: ArrayList<ExampleItem>,
    val context: Context,
    private val exampleViewModel: ExampleViewModel
) :
    RecyclerView.Adapter<ExampleViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ExampleItemBinding.inflate(inflater, parent, false)
        return ExampleViewHolder(binding, exampleViewModel)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val item = mExampleList[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return mExampleList.size
    }
}