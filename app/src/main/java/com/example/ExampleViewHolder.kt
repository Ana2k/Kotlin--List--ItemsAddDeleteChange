package com.example

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding

class ExampleViewHolder(private val binding: ExampleItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object{
        fun from(parent: ViewGroup): ExampleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            // LayoutInflater: takes ID from layout defined in XML.
            // Instantiates the layout XML into corresponding View objects.
            // Use context from main app -> also supplies theme layout values!
            // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
            val binding = ExampleItemBinding.inflate(inflater, parent, false)
            //so moral of story binding happens in onCreate and is named according to xml file name
            return ExampleViewHolder(binding)
        }
    }
    fun bind(clickListener: ExampleItemListener,item: ExampleItem) {
        binding.item = item
        binding.clickListener = clickListener
        //clickListener instead of ViewModel
        binding.executePendingBindings()
    }
}


class ExampleItemDiffCallback :
    DiffUtil.ItemCallback<ExampleItem>() {
    override fun areItemsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
        return oldItem == newItem
    }
}
///BINDING ADAPTER SHOULD WE USE IT???