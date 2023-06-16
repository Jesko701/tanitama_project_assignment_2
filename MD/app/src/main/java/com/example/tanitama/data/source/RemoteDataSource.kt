//package com.example.tanitama.data.source
//
//import com.example.tanitama.data.response.ApiService
//import com.example.tanitama.model.UserRequest
//import com.example.tanitama.model.UserResponse
//import com.example.tanitama.model.auth.LoginRequest
//import com.example.tanitama.model.auth.LoginResponse
//import javax.inject.Inject
//import javax.inject.Singleton
//
//@Singleton
//class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
//    suspend fun login (
//        username: String,
//        password: String
//    ) : LoginResponse? {
//        val loginRequest = LoginRequest(username, password)
//        val response = apiService.login(loginRequest)
//        return if (response.isSuccessful) {
//            response.body()
//        } else {
//            null
//        }
//    }
//    suspend fun signUp (
//        username: String,
//        email: String,
//        password: String,
//        confirm_password: String
//    ) : UserResponse? {
//        val userRequest = UserRequest(username, email, password, confirm_password)
//        val response = apiService.createUser(userRequest)
//        return if (response.isSuccessful) {
//            response.body()
//        } else {
//            null
//        }
//    }
//}