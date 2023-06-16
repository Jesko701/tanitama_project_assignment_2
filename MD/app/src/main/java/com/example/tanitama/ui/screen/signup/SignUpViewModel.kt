//package com.example.tanitama.ui.screen.signup
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.tanitama.LoginState
//import com.example.tanitama.SignUpState
//import com.example.tanitama.data.repository.WeatherRepository
//import com.example.tanitama.data.response.ApiService
//import com.example.tanitama.data.retrofit.ApiConfig
//import com.example.tanitama.model.UserRequest
//import com.example.tanitama.model.UserResponse
//import com.example.tanitama.util.Resource
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import retrofit2.Response
//import javax.inject.Inject
//
//@HiltViewModel
//class SignUpViewModel @Inject constructor(
//    private val repository: WeatherRepository,
//    private val apiService: ApiService
//) : ViewModel() {
//    var state by mutableStateOf(SignUpState())
//        private set
//
//    //    private val apiService = ApiConfig.getApiService()
////    suspend fun signUp(username: String, email: String, password: String, confirmPassword: String): Response<UserResponse> {
////        val userRequest = UserRequest(username, email, password, confirmPassword)
////        return apiService.createUser(userRequest)
////    }
//    suspend fun signUp(
//        username: String,
//        email: String,
//        password: String,
//        confirm_password: String
//    ): Response<UserResponse> {
//        var response: Response<UserResponse>? = null
//        viewModelScope.launch {
//            state = state.copy(
//                isLoading = true,
//                error = null
//            )
////            when (val result = repository.signUp(username, email, password, confirm_password)) {
////                is Resource.Success -> {
////                    state = state.copy(
////                        userResponse = result.data,
////                        isLoading = false,
////                        error = null
////                    )
////                }
////
////                is Resource.Error -> {
////                    state = state.copy(
////                        userResponse = null,
////                        isLoading = false,
////                        error = result.message
////                    )
////                }
////            }
//            val userRequest = UserRequest(username, email, password, confirm_password)
////            var response = apiService.createUser(userRequest)
////            if (response.isSuccessful) {
////                val userResponse: UserResponse? = response.body()
////                state = state.copy(
////                    userResponse = userResponse,
////                    isLoading = false,
////                    error = null
////                )
////            } else {
////                state = state.copy(
////                    userResponse = null,
////                    isLoading = false,
////                    error = response.message() ?: "Proses sign up gagal"
////                )
////            }
////        }
//            try {
//                response = apiService.createUser(userRequest)
//                if (response!!.isSuccessful) {
//                    val userResponse: UserResponse? = response!!.body()
//                    state = state.copy(
//                        userResponse = userResponse,
//                        isLoading = false,
//                        error = null
//                    )
//                } else {
//                    state = state.copy(
//                        userResponse = null,
//                        isLoading = false,
//                        error = response!!.message() ?: "Proses sign up gagal"
//                    )
//                }
//            } catch (e: Exception) {
//                state = state.copy(
//                    userResponse = null,
//                    isLoading = false,
//                    error = e.message ?: "Proses sign up gagal"
//                )
//            }
//        }
//        return response!!
//    }
//}