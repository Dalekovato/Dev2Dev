package com.example.dev2dev.data.dtoUser

import com.google.gson.annotations.SerializedName

data class User (

  @SerializedName("email")val email : String,
  @SerializedName("password")val password : String,

)