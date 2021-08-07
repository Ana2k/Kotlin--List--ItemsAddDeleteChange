package com.example

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

    //bindingAdapter used so that we dont have to write a tonn of binding.textView etc things
    //in fun bind in viewholder
    //or you can your choice this is to use the data variable basically-- you can just do the viewholder thing too
    //no issues
    //you can refer to layout files of mars-real_estate part

    @BindingAdapter("textViewFirst")
    fun TextView.SetFirstText(item: ExampleItem?) {
        item?.let {
            text = item.text1
        }//in case we have a null value then what? item can be null tooo...
    }
        @BindingAdapter("textViewSecond")
        fun TextView.SetSecondText(item: ExampleItem?) {
            item?.let {
                text = item.text2
            }//in case we have a null value then what? item can be null tooo...
        }

        @BindingAdapter("imageView")
        fun ImageView.setExampleImage(item: ExampleItem) {
            setImageResource(item.imageResource)
        }


