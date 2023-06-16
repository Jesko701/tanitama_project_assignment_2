package com.example.tanitama.model.home

import androidx.annotation.DrawableRes

data class Item(
    val title: String,
    val description: String,
    val destination: String,
    @DrawableRes val imageResId: Int)
