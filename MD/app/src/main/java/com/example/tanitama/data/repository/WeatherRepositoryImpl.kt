package com.example.tanitama.data.repository

import com.example.tanitama.data.mappers.toWeatherInfo
import com.example.tanitama.data.response.ApiService
import com.example.tanitama.model.weather.WeatherInfo
import com.example.tanitama.util.Resource
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(private val api: ApiService): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Terjadi kesalahan ")
        }
    }

//    override suspend fun login(username: String, password: String): Resource<LoginResponse> {
//        return try {
//            Resource.Success(
//                data = api.login(
//                    LoginRequest(
//                        username = username,
//                        password = password
//                    )
//                ).toLoginResponse()
//            )
//        } catch(e: Exception) {
//            e.printStackTrace()
//            Resource.Error(e.message ?: "Terjadi kesalahan ")
//        }
//    }
//
//    override suspend fun signUp(
//        username: String,
//        email: String,
//        password: String,
//        confirm_password: String
//    ): Resource<UserResponse> {
//        return try {
//            Resource.Success(
//                data = api.createUser(
//                    UserRequest(
//                        username = username,
//                        email = email,
//                        password = password,
//                        confirm_password = confirm_password
//                    )
//                ).toUserResponse()
//            )
//        } catch(e: Exception) {
//            e.printStackTrace()
//            Resource.Error(e.message ?: "Terjadi kesalahan ")
//        }
//    }

//    override suspend fun getLocationName(lat: Double, long: Double): Resource<String> {
//        return try {
//            val response = api.getLocationName(lat, long)
//            val locationName = response.results.firstOrNull()?.formattedAddress
//            if (locationName != null) {
//                Resource.Success(data = locationName)
//            } else {
//                Resource.Error("Failed to get location name")
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Resource.Error(e.message ?: "Terjadi kesalahan")
//        }
//    }
}