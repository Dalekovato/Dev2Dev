package com.example.dev2dev.domain.interactor

import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.utils.NetworkResult

interface IAuthInteractor {

    suspend fun singIn(user: AuthUser): NetworkResult<ApiToken>

    suspend fun singUn(user: AuthUser): NetworkResult<ApiToken>

    suspend fun saveToken(token: ApiToken)

    suspend fun getAccessToken():String

    suspend fun getRefreshToken():String

    suspend fun clearToken()

}