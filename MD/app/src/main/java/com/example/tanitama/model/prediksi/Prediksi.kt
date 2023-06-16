package com.example.tanitama.model.prediksi

import java.util.*

/**
 * See Recipe example: https://food2fork.ca/
 */
data class Prediksi (
    val id: Int,
    val title: String,
    val publisher: String,
    val featuredImage: String,
    val rating: Int,
    val sourceUrl: String,
    val ingredients: List<String> = listOf(),
    val dateAdded: Date,
    val dateUpdated: Date,
)