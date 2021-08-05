package com.example

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding


class ExampleItemAdapter(private val context: Context, private val mExampleList: ArrayList<ExampleItem>,private val viewModel: ExampleViewModel ) : RecyclerView.Adapter<ExampleViewHolder>() {
    //1) create the viewHolders
    //2) create inside code of CreateView holder
    //3) create inside onBindViewHolder
    //4) create size-- getItemCount
    //inspired by https://github.com/andijakl/PartsList/blob/master/01-RecyclerView/app/src/main/java/com/andreasjakl/partslist/PartAdapter.kt


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ExampleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val binding = ExampleItemBinding.inflate(inflater,parent,false)
        //so moral of story binding happens in onCreate and is named according to xml file name
        return ExampleViewHolder(binding,viewModel)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val item = mExampleList[position]
        holder.bind(item,position)
    }

    override fun getItemCount() = mExampleList.size
}
