//package com.example.tanitama.ui.screen.signin
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
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.IconButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.tanitama.R
//
////@Composable
////fun SignIn(signInViewModel: SignInViewModel = viewModel(), navController: NavController, state: LoginState) {
////    val username = remember { mutableStateOf("") }
////    val password = remember { mutableStateOf("") }
////    var loginError by remember { mutableStateOf(false) }
////    var errorMessage by remember { mutableStateOf("") }
////
////    val scope = rememberCoroutineScope()
////    state.loginResponse?.let {
////        if (it.token?.isNotEmpty() == true) {
////            navController.navigate("home")
////        }
////    }
//////    val success = false // Contoh inisialisasi
//////    val isSuccess = true // Perubahan disini
////
////    Box(modifier = Modifier.fillMaxSize()) {
////        Image(
////            painter = painterResource(R.drawable.bg),
////            contentDescription = null,
////            modifier = Modifier.fillMaxSize(),
////            contentScale = ContentScale.Crop
////        )
////        Column(
////            modifier = Modifier
////                .fillMaxSize()
////                .padding(20.dp),
////            verticalArrangement = Arrangement.Center,
////            horizontalAlignment = Alignment.CenterHorizontally) {
////            Image(
////                painter = painterResource(R.drawable.logo),
////                contentDescription = "Logo Tanitama",
////                modifier = Modifier
////                    .size(150.dp),
////                contentScale = ContentScale.Fit
////            )
////            SectionText(stringResource(R.string.title_activity_sign_in))
////            CornerTextField(
////                value = username.value, // display state
////                onValueChange = { username.value = it },
////                placeholder = "Username",
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
////                cornerRadius = 19.dp,
////                backgroundColor = Color.White.copy(alpha = 0.9f),
////                borderColor = Color.Gray,
////                textColor = Color.Gray,
////                keyboardOptions = KeyboardOptions.Default
////            )
////            CornerTextFieldPassword(
////                value = password.value, // display state
////                onValueChange = { password.value = it },
////                placeholder = "Password",
////                visualTransformation = PasswordVisualTransformation(),
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
////                cornerRadius = 19.dp,
////                backgroundColor = Color.White.copy(alpha = 0.9f),
////                borderColor = Color.Gray,
////                textColor = Color.Black
////            )
////
////            if (loginError) {
////                Text(
////                    text = errorMessage,
////                    color = Color.Red,
////                    modifier = Modifier.padding(top = 8.dp)
////                )
////            }
////
////            ButtonGreen(
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
////                onClick = {
////                    val usernameValue = username.value
////                    val passwordValue = password.value
////                    if (isInputValid(usernameValue, passwordValue)) {
////                        scope.launch {
////                            signInViewModel.login(usernameValue, passwordValue)
////                        }
////                    } else {
////                        // Input tidak valid, tampilkan pesan error
////                        loginError = true
////                        errorMessage = "Username dan password harus diisi"
////                    }
////                },
////                text = "SIGN IN",
////                colors = ButtonDefaults.textButtonColors(
////                    containerColor = Color(0xFF00CF6C).copy(alpha = 0.6f),
////                    contentColor = Color.White
////                )
////
////            )
////        }
////    }
////}
////
////private fun isInputValid(username: String, password: String): Boolean {
////    return username.isNotBlank() && password.isNotBlank()
////}
//
////onClick = { scope.launch {
////    val usernameValue = username.value
////    val passwordValue = password.value
////    if (!usernameValue.isNullOrBlank() && !passwordValue.isNullOrBlank()) {
////        val isSuccess: Boolean? = signInViewModel.login(usernameValue, passwordValue)?.toBoolean()
////        loginError = isSuccess != true
////        if (isSuccess != true) {
////            navController.navigate("signin")
////            loginError = true
////            errorMessage = "Proses sign up gagal"
////        }
////    }
////}},
//
//@Preview
//@Composable
//fun SignIn() {
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
//            Logo()
//            Title()
//            Username()
//            Password()
//            SigninButton()
//        }
//    }
//}
//
//@Composable
//fun SigninButton() {
//    ButtonGreen(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//        onClick = {},
//        text = stringResource(R.string.sign_in),
//        colors = ButtonDefaults.textButtonColors(
//            containerColor = Color(0xFF00CF6C).copy(alpha = 0.6f),
//            contentColor = Color.White
//        )
//    )
//}
//
//@Composable
//fun Password() {
//    val passwordState = remember { mutableStateOf(TextFieldValue()) }
//    val showPassword = remember { mutableStateOf(false) }
//    CornerTextFieldPassword(
//        value = passwordState.value, // display state
//        onValueChange = { passwordState.value = it },
//        placeholder = stringResource(R.string.password),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//        cornerRadius = 19.dp,
//        backgroundColor = Color.White.copy(alpha = 0.9f),
//        borderColor = Color.Gray,
//        textColor = Color.Gray,
//        visualTransformation = PasswordVisualTransformation(),
//        trailingIcon = {
//            if (showPassword.value) {
//                IconButton(onClick = { }) {
//
//                }
//            }  else {
//
//            }
//        }
//    )
//}
//
//@Composable
//fun Username() {
//    val usernameState = remember { mutableStateOf(TextFieldValue()) }
//    CornerTextField(
//        value = usernameState.value, // display state
//        onValueChange = { usernameState.value = it },
//        placeholder = stringResource(R.string.username),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//        cornerRadius = 19.dp,
//        backgroundColor = Color.White.copy(alpha = 0.9f),
//        borderColor = Color.Gray,
//        textColor = Color.Gray
//    )
//}
//
//@Composable
//fun Title() {
//    SectionText(stringResource(R.string.title_activity_sign_in))
//}
//
//@Composable
//fun Logo() {
//    Image(
//        painter = painterResource(R.drawable.logo),
//        contentDescription = "Logo Tanitama",
//        modifier = Modifier
//            .size(150.dp),
//        contentScale = ContentScale.Fit
//    )
//}
