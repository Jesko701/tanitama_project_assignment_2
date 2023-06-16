package com.example.tanitama.data.retrofit

import com.example.tanitama.model.UserRequest
import com.example.tanitama.model.UserResponse
import com.example.tanitama.model.auth.LoginRequest
import com.example.tanitama.model.auth.LoginResponse
import com.example.tanitama.model.weather.WeatherDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WeatherApi {
    @POST("users")
    suspend fun createUser(@Body request: UserRequest): Response<UserResponse>

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("weather")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double?,
        @Query("longitude") long: Double?
    ) : WeatherDto
}