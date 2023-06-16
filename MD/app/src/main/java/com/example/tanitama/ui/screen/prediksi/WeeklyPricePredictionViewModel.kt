package com.example.tanitama.ui.screen.prediksi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tanitama.data.response.ApiService
import com.example.tanitama.model.prediksi.PricePrediction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeeklyPricePredictionViewModel(private val apiService: ApiService) : ViewModel() {
//    var bawangMerahPrice: Float = 0f
//    var bawangPutihPrice: Float = 0f
//    var berasPrice: Float = 0f
//    var cabaiMerahPrice: Float = 0f
    var pricePrediction: PricePrediction? = null

    fun fetchPricePrediction() {
        viewModelScope.launch {
            try {
                pricePrediction = apiService.getPriceWeeklyPrediction()
//                withContext(Dispatchers.Main) {
//                    bawangMerahPrice = prediction.bawangMerah[0]
//                    bawangPutihPrice = prediction.bawangPutih[0]
//                    berasPrice = prediction.beras[0]
//                    cabaiMerahPrice = prediction.cabaiMerah[0]
//                }
            } catch (e: Exception) {
                // Handle API call failure
            }
        }
    }
}