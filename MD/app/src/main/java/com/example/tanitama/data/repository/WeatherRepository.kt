package com.example.tanitama.data.repository

import com.example.tanitama.model.UserResponse
import com.example.tanitama.model.auth.LoginResponse
import com.example.tanitama.model.weather.WeatherInfo
import com.example.tanitama.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
//    suspend fun login(username: String, password: String): Resource<LoginResponse>
//    suspend fun signUp(username: String, email: String, password: String, confirm_password: String): Resource<UserResponse>
//    suspend fun getLocationName(lat: Double, long: Double): Resource<String>
}