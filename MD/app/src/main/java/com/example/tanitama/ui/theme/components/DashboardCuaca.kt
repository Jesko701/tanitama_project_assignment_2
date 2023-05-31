package com.example.tanitama.ui.theme.components

import CornerTextField
import SectionText
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tanitama.R
import com.example.tanitama.ui.theme.TanitamaTheme

@Composable
fun Cuaca() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = "27 C",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Tegal",
                style = TextStyle(
                    fontSize = 14.sp
                )
            )
        }
        Spacer(modifier = Modifier.width(30.dp))
        Image(
            painter = painterResource(R.drawable.pasar),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CuacaPreview() {
    TanitamaTheme {
        Cuaca()
    }
}

//@Composable
//fun WidgetCuaca() {
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
//                value = usernameState.value, // display state
//                onValueChange = { usernameState.value = it },
//                placeholder = "Username",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
//                cornerRadius = 19.dp,
//                backgroundColor = Color.White.copy(alpha = 0.9f),
//                borderColor = Color.Gray,
//                textColor = Color.Black
//            )
//        }
//    }
//}