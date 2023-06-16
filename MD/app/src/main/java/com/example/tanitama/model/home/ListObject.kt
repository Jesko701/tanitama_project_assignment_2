package com.example.tanitama.model

import android.content.Context
import com.example.tanitama.R
import com.example.tanitama.model.home.Item

object ListObject {
    private lateinit var context: Context
    val itemList = listOf(
        Item(context.getString(R.string.saran_harga), context.getString(R.string.desc_saran_harga), "prediksi",R.drawable.saran_harga),
        Item(context.getString(R.string.deteksi_penyakit), context.getString(R.string.desc_deteksi_penyakit), "deteksi", R.drawable.deteksi_penyakit),
        Item(context.getString(R.string.ketersediaan_pangan), context.getString(R.string.desc_ketersediaan_pangan), "pasar",R.drawable.pasar)
    )
}