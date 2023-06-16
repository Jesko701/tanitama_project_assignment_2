package com.example.tanitama.ui.screen.prediksi

import TanitamaApp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.tanitama.App

@Composable
fun Prediksi() {
    Column {
        Text(text = "Prediksi")
    }
}

@Preview(showBackground = true)
@Composable
fun PrediksiView() {
    Prediksi()
}