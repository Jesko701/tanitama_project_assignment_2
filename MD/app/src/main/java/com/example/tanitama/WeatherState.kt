package com.example.tanitama

import com.example.tanitama.model.UserResponse
import com.example.tanitama.model.auth.LoginResponse
import com.example.tanitama.model.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)