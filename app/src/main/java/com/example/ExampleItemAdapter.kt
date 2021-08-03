package com.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclereviewplaylistyt.databinding.ExampleItemBinding


class ExampleItemAdapter(mExampleList: ArrayList<ExampleItem>) : RecyclerView.Adapter<ExampleViewHolder>() {
    //1) create the viewHolders
    //2) create inside code of CreateView holder
    //3) create inside onBindViewHolder
    //4) create size-- getItemCount
    //inspired by https://github.com/andijakl/PartsList/blob/master/01-RecyclerView/app/src/main/java/com/andreasjakl/partslist/PartAdapter.kt


    //vars declared
    private lateinit var mExampleList: ArrayList<ExampleItem>
    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onDeleteClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ExampleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val binding = ExampleItemBinding.inflate(inflater,parent,false)
        //so moral of story binding happens in onCreate and is named according to xml file name
        return ExampleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        //trying sth from this gloc: https://github.com/andijakl/PartsList/blob/master/01-RecyclerView/app/src/main/java/com/andreasjakl/partslist/PartAdapter.kt
//        val itemViewHolder = holder as ExampleViewHolder
//        val currentItem: ExampleItem = mExampleList[position]
//        holder.mTextViewFirst.text = currentItem.text1
//        holder.mTextViewSecond.text = currentItem.text2
//        holder.mImageView.setImageResource(currentItem.imageResource)
        val item = mExampleList[position]
        holder.bind(item)
    }

    override fun getItemCount() = mExampleList.size
}
