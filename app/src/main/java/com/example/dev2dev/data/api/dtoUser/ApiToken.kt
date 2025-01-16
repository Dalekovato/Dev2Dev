package com.example.dev2dev.data.api.dtoUser

import com.google.gson.annotations.SerializedName

data class ApiToken(

    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,

    )