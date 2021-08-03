package com.example

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("exampleTextViewFirst")
fun TextView.setSleepDurationFormatted(item: ExampleItem?) {
    item?.let {
        text = item.text1
    }
}

@BindingAdapter("exampleTextViewSecond")
fun TextView.setSleepQualityString(item: ExampleItem?) {
    item?.let {
        text = item.text2
    }
}

@BindingAdapter("exampleImage")
fun ImageView.setExampleImage(item: ExampleItem) {
    setImageResource(item.imageResource)
}