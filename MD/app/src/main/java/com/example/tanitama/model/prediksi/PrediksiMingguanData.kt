package com.example.tanitama.model.prediksi

data class WeeklyPricePrediction(
    val bawangMerah: Double,
    val bawangPutih: Double,
    val beras: Double,
    val cabaiMerah: Double,
)

data class PricePrediction(
    val bawangMerah: List<Float?>,
    val bawangPutih: List<Float?>,
    val beras: List<Float?>,
    val cabaiMerah: List<Float?>
)