package com.example.tanitama.model.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelcius: Double,
    val rainSum: Double,
    val windDirection: Double,
    val windSpeed: Double,
    val weatherType: WeatherType
)
