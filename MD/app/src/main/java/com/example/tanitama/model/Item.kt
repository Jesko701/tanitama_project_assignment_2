package com.example.tanitama.model

import androidx.annotation.DrawableRes

data class Item(
    val title: String,
    val description: String,
    @DrawableRes val imageResId: Int)
