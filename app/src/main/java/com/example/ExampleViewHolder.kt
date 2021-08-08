package com.example

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding
import timber.log.Timber

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
            Timber.d("Viewholder.from this was called")
            //so moral of story binding happens in onCreate and is named according to xml file name

            return ExampleViewHolder(binding)///is this recursion happening??
        }
    }
    fun bind(clickListener: ExampleItemListener,item: ExampleItem, clickChangeListener: ExampleItemChangeListener) {
        binding.item = item
        binding.clickListener = clickListener
        binding.clickChangeListener=clickChangeListener
        //clickListener instead of ViewModel
        binding.executePendingBindings()
    }
}


class ExampleItemDiffCallback :
    DiffUtil.ItemCallback<ExampleItem>() {
    override fun areItemsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
        Timber.tag("areItems").d("reItemsTheSame this was called")

        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
        Timber.tag("areContentsSame").d("areContentssaame this was called")

        return oldItem == newItem
    }
}
///BINDING ADAPTER SHOULD WE USE IT???