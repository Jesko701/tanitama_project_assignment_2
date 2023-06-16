package com.example.tanitama.model.prediksi

import com.google.gson.annotations.SerializedName

data class PrediksiResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Data(

	@field:SerializedName("Beras")
	val beras: List<Any?>? = null,

	@field:SerializedName("Bawang Putih")
	val bawangPutih: List<Any?>? = null,

	@field:SerializedName("Bawang Merah")
	val bawangMerah: List<Any?>? = null,

	@field:SerializedName("Cabai Merah")
	val cabaiMerah: List<Any?>? = null
)
