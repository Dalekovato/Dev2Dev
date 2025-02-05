package com.example.dev2dev.data.api.dtoUser

import com.google.gson.annotations.SerializedName

data class AuthUserDto(

    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,

    )