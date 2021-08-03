package com.example

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding

class ExampleViewHolder private constructor(
   val binding: ExampleItemBinding,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(clickListener:ExampleItemListener, item: ExampleItem) {
        binding.item = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ExampleViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ExampleItemBinding.inflate(layoutInflater,parent,false)
            return ExampleViewHolder(binding)
        }
    }
}

class ExampleDiffCallback : DiffUtil.ItemCallback<ExampleItem>() {
    override fun areItemsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
        return oldItem == newItem
    }
}
