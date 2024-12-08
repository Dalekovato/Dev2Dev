package com.example.dev2dev.data.jwtToken

interface ILocalTokenRepository {

    fun setRefreshToken(refreshToken : String)

    fun setAccessToken(accessToken : String)

    fun getRefreshToken():String

    fun getAccessToken():String
}