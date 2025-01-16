package com.example.dev2dev.data.jwtToken

import javax.inject.Inject

class LocalTokenRepository @Inject constructor(

) : ILocalTokenRepository {

    private var jwtrefreshToken: String? = ""
    private var jwtaccessToken: String? = ""

    override fun setRefreshToken(refreshToken: String) {
        this.jwtrefreshToken = refreshToken
    }

    override fun setAccessToken(accessToken: String) {
        this.jwtaccessToken = accessToken

    }

    override fun getRefreshToken(): String = jwtrefreshToken.toString()

    override fun getAccessToken(): String = jwtaccessToken.toString()

}