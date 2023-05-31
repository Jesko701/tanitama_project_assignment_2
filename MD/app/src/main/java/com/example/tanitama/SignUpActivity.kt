@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tanitama

import ButtonGreen
import CornerTextField
import CornerTextFieldPassword
import SectionText
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tanitama.ui.theme.TanitamaTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TanitamaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun SignUp() {
    val emailState = remember { mutableStateOf("") }
    val usernameState = remember { mutableStateOf("") }
    val password1State = remember { mutableStateOf("") }
    val password2State = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo Tanitama",
                modifier = Modifier
                    .size(150.dp),
                contentScale = ContentScale.Fit
            )
            SectionText(stringResource(R.string.title_activity_sign_up))
            CornerTextField(
                value = usernameState.value, // display state
                onValueChange = { usernameState.value = it },
                placeholder = "Username",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
                cornerRadius = 19.dp,
                backgroundColor = Color.White.copy(alpha = 0.9f),
                borderColor = Color.Gray,
                textColor = Color.Black
            )
            CornerTextField(
                value = emailState.value, // display state
                onValueChange = { emailState.value = it },
                placeholder = "Email",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
                cornerRadius = 19.dp,
                backgroundColor = Color.White.copy(alpha = 0.9f),
                borderColor = Color.Gray,
                textColor = Color.Black,
            )
            CornerTextFieldPassword(
                value = password1State.value, // display state
                onValueChange = { password1State.value = it },
                placeholder = "Password",
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
                cornerRadius = 19.dp,
                backgroundColor = Color.White.copy(alpha = 0.9f),
                borderColor = Color.Gray,
                textColor = Color.Black
            )
            CornerTextFieldPassword(
                value = password2State.value, // display state
                onValueChange = { password2State.value = it },
                placeholder = "Confirm Password",
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
                cornerRadius = 19.dp,
                backgroundColor = Color.White.copy(alpha = 0.9f),
                borderColor = Color.Gray,
                textColor = Color.Black
            )
            ButtonGreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
                onClick = { /* Handle SignIn Button Click */ },
                text = "SIGN UP",
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color(0xFF00CF6C).copy(alpha = 0.6f),
                    contentColor = Color.White
                )

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    TanitamaTheme {
        SignUp()
    }
}