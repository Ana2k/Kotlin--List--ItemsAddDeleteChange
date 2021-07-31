package com.example

data class ExampleItem(
    val imageResource: Int,
    var text1: String,
    var text2: String,
) {
    fun changeText1(text: String) {
        text1 = text
    }

}

