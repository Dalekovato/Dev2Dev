package com.example.dev2dev.data.Jwt

import android.util.Log
import javax.inject.Inject

class LocalTokenRepository @Inject constructor() {

    var JwtrefreshToken : String = ""
    var JwtaccessToken : String = ""

    fun setRefreshToken(refreshToken : String){
        this.JwtrefreshToken = refreshToken
        Log.d("TokenTUTUTUTU", "${refreshToken}")

    }

    fun setAccessToken(accessToken : String){
        this.JwtaccessToken = accessToken

    }

    fun getRefreshToken():String = JwtrefreshToken



    fun getAccessToken():String = JwtaccessToken

}