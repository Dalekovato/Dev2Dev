package com.example.dev2dev.data.Jwt

import com.example.dev2dev.data.api.dtoUser.ApiToken

interface JwtTokenManager {

    suspend fun saveAccessJwt(token: String)
    suspend fun saveRefreshJwt(token: String)
    suspend fun getAccessJwt(): String?
    suspend fun getRefreshJwt(): String?
    suspend fun clearAllTokens()


}