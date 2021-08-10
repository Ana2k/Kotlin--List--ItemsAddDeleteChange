package com.example

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding


class ExampleItemAdapter(private val clickListener: ExampleItemListener,private val changeTextListener: ExampleItemChangeTextListener) :
    ListAdapter<ExampleItem, ExampleViewHolder>(ExampleItemDiffCallback()) {
    //1) create the viewHolders
    //2) create inside code of CreateView holder
    //3) create inside onBindViewHolder
    //4) create size-- getItemCount
    //inspired by https://github.com/andijakl/PartsList/blob/master/01-RecyclerView/app/src/main/java/com/andreasjakl/partslist/PartAdapter.kt


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        return ExampleViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener,changeTextListener,item)
    }

}
//both the listeners
 class ExampleItemListener(val clickListener: (id:Long)->Unit){
     fun onClick(item: ExampleItem) = clickListener(item.id)
 }
class ExampleItemChangeTextListener(val changeTextListener: (id: Long)-> Unit){
    fun onClick(item: ExampleItem) = changeTextListener(item.id)
}

