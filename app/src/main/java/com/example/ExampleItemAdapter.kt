package com.example

import android.view.ViewGroup
import com.example.ExampleItem
import com.example.ExampleViewHolder


class ExampleItemAdapter(val clickListener: ExampleItemListener) :
    androidx.recyclerview.widget.ListAdapter<ExampleItem, ExampleViewHolder>(ExampleDiffCallback()) {

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        return ExampleViewHolder.from(parent)
    }
}

class ExampleItemListener(val clickListener: (id: Long) -> Unit) {
    fun onClick(item: ExampleItem) = clickListener(item.id)
}

