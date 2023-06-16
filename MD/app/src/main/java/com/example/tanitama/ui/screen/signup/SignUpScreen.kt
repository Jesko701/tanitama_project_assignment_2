//package com.example.tanitama.ui.screen.signup
//
//import ButtonGreen
//import CornerTextField
//import CornerTextFieldPassword
//import SectionText
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.example.tanitama.R
//import com.example.tanitama.model.UserResponse
//import kotlinx.coroutines.launch
//import retrofit2.Response
//
//@Composable
//fun SignUp(
//    signUpViewModel: SignUpViewModel = viewModel(),
//    navController: NavController
//) {
//    val email = remember { mutableStateOf("") }
//    val username = remember { mutableStateOf("") }
//    val password = remember { mutableStateOf("") }
//    val confirm_password = remember { mutableStateOf("") }
//    val signUpError = remember { mutableStateOf(false) }
//    val errorMessage = remember { mutableStateOf("") }
//
//    fun validateInput(
//        username: String,
//        email: String,
//        password: String,
//        confirm_password: String
//    ): Boolean {
//        if (username.isBlank() || email.isBlank() || password.isBlank() || confirm_password.isBlank()) {
//            signUpError.value = true
//            errorMessage.value = "Mohon lengkapi semua field"
//            return false
//        }
//
//        if (password.length < 8) {
//            signUpError.value = true
//            errorMessage.value = "Kata sandi harus memiliki panjang minimal 8 karakter"
//            return false
//        }
//
//        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
//        if (!email.matches(emailPattern)) {
//            signUpError.value = true
//            errorMessage.value = "Format email tidak valid"
//            return false
//        }
//
//        if (password != confirm_password) {
//            signUpError.value = true
//            errorMessage.value = "Password tidak sama dengan sebelumnya"
//            return false
//        }
//
//        signUpError.value = false
//        errorMessage.value = ""
//        return true
//    }
//
//    signUpError.value = false
//    val scope = rememberCoroutineScope()
//    val isInputValid = validateInput(username.value, email.value, password.value, confirm_password.value)
//
//
//    // Fungsi untuk meng-handle tindakan tombol SIGN UP
//    fun handleSignUp() {
//        if (isInputValid) {
//            scope.launch {
//                val response: Response<UserResponse> =
//                    signUpViewModel.signUp(
//                        username.value,
//                        email.value,
//                        password.value,
//                        confirm_password.value
//                    )
//                if (response.isSuccessful) {
//                    val userResponse: UserResponse? = response.body()
//                    val message: String? = userResponse?.message
//                    if (message == "Berhasil membuat data") {
//                        // Sign up successful, navigate to the next screen
//                        navController.navigate("signin")
//                    } else {
//                        signUpError.value = true
//                        errorMessage.value = message ?: "Proses sign up gagal"
//                    }
//                } else {
//                    signUpError.value = true
//                    errorMessage.value = response.message() ?: "Proses sign up gagal"
//                }
//            }
//        } else {
//            signUpError.value = true
//            errorMessage.value = "Mohon lengkapi semua field"
//        }
//    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        Image(
//            painter = painterResource(R.drawable.bg),
//            contentDescription = null,
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(20.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Image(
//                painter = painterResource(R.drawable.logo),
//                contentDescription = "Logo Tanitama",
//                modifier = Modifier
//                    .size(150.dp),
//                contentScale = ContentScale.Fit
//            )
//            SectionText(stringResource(R.string.title_activity_sign_up))
//            CornerTextField(
//                value = username.value, // display state
//                onValueChange = { username.value = it },
//                placeholder = "Username",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//                cornerRadius = 19.dp,
//                backgroundColor = Color.White.copy(alpha = 0.9f),
//                borderColor = Color.Gray,
//                textColor = Color.Black,
//                keyboardOptions = KeyboardOptions.Default
//            )
//            CornerTextField(
//                value = email.value, // display state
//                onValueChange = { email.value = it },
//                placeholder = "Email",
//                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//                cornerRadius = 19.dp,
//                backgroundColor = Color.White.copy(alpha = 0.9f),
//                borderColor = Color.Gray,
//                textColor = Color.Black,
//            )
//            CornerTextFieldPassword(
//                value = password.value, // display state
//                onValueChange = { password.value = it },
//                placeholder = "Password",
//                visualTransformation = PasswordVisualTransformation(),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//                cornerRadius = 19.dp,
//                backgroundColor = Color.White.copy(alpha = 0.9f),
//                borderColor = Color.Gray,
//                textColor = Color.Black
//            )
//            CornerTextFieldPassword(
//                value = confirm_password.value, // display state
//                onValueChange = { confirm_password.value = it },
//                placeholder = "Confirm Password",
//                visualTransformation = PasswordVisualTransformation(),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//                cornerRadius = 19.dp,
//                backgroundColor = Color.White.copy(alpha = 0.9f),
//                borderColor = Color.Gray,
//                textColor = Color.Black
//            )
//
//            if (signUpError.value) {
//                Text(
//                    text = "Sign up failed. ${errorMessage.value}",
//                    color = Color.Red,
//                    modifier = Modifier.padding(top = 8.dp)
//                )
//            } else {
//                Text(
//                    text = "",
//                    modifier = Modifier.padding(top = 8.dp)
//                )
//            }
//
//            ButtonGreen(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//                onClick = { handleSignUp() },
//                text = "SIGN UP",
//                colors = ButtonDefaults.textButtonColors(
//                    containerColor = Color(0xFF00CF6C).copy(alpha = 0.6f),
//                    contentColor = Color.White
//                )
//
//            )
//        }
//    }
//}