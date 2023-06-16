//package com.example.tanitama.ui.screen.signin
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.tanitama.LoginState
//import com.example.tanitama.data.repository.WeatherRepository
//import com.example.tanitama.util.Resource
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class SignInViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {
//    var state by mutableStateOf(LoginState())
//        private set
//
//    fun login(username: String, password: String) {
//        viewModelScope.launch {
//            state = state.copy(
//                isLoading = true,
//                error = null
//            )
//            when(val result = repository.login(username, password)) {
//                is Resource.Success -> {
//                    state = state.copy(
//                        loginResponse = result.data,
//                        isLoading = false,
//                        error = null
//                    )
//                }
//                is Resource.Error -> {
//                    state = state.copy(
//                        loginResponse = null,
//                        isLoading = false,
//                        error = result.message
//                    )
//                }
//            }
//        }
//    }
//}