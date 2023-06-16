package com.example.tanitama.model.auth

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("username")
    val username: String? = null
)

