package com.example.dev2dev.data.Jwt

class LocalTokenRepository {

    var refreshToken : String = ""
    var accessToken : String = ""

    fun setRefreshToken(refreshToken : String){
        this.refreshToken = refreshToken
    }

    fun setRAccessToken(accessToken : String){
        this.accessToken = accessToken
    }

    fun getRefreshToken(): String = refreshToken

    fun getAccessToken():String = accessToken

}