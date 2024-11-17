package com.example.dev2dev.data.api.dtoUser

import com.google.gson.annotations.SerializedName

data class ApiToken (

    @SerializedName("accessToken")val accessToken : String,
    @SerializedName("refreshToken")val refreshToken : String,

)