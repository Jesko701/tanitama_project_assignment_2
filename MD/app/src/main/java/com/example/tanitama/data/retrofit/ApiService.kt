package com.example.tanitama.data.response

import com.example.tanitama.model.auth.LoginRequest
import com.example.tanitama.model.auth.LoginResponse
import com.example.tanitama.model.UserRequest
import com.example.tanitama.model.UserResponse
import com.example.tanitama.model.prediksi.PricePrediction
import com.example.tanitama.model.prediksi.WeeklyPricePrediction
import com.example.tanitama.model.weather.WeatherDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("users")
    suspend fun createUser(@Body request: UserRequest): Response<UserResponse>

    @POST("login")
//    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
    suspend fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("weather")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double?,
        @Query("longitude") long: Double?
    ) : WeatherDto

    @GET("predict")
    suspend fun getPriceWeeklyPrediction(): PricePrediction

//    @GET("/users")
//    suspend fun getUser(@Path("userId") userId: String): Response<UserResponse>

}