package com.example.tanitama.model.weather

import com.google.gson.annotations.SerializedName

data class WeatherDataDto(
    val time: List<String>,
    @field:SerializedName("temperature") val temperatures: List<Double>,
    @field:SerializedName("weathercode") val weatherCodes: List<Int>,
    @field:SerializedName("rain_sum") val rainSums: List<Double>,
    @field:SerializedName("winddirection") val windDirections: List<Double>,
    @field:SerializedName("windspeed") val windSpeeds: List<Double>,
)
