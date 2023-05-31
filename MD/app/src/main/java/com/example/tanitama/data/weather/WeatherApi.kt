package com.example.tanitama.data.weather

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    )
}