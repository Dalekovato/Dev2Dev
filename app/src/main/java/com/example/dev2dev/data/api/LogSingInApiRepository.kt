package com.example.dev2dev.data.api

import android.util.Log
import com.example.dev2dev.data.Jwt.LocalTokenRepository
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.utils.BaseApiResponse
import com.example.dev2dev.utils.NetworkResult
import javax.inject.Inject

class LogSingInApiRepository @Inject constructor(
    private val iLogSingInApi: ILogSingApiService,
    private val localTokenRepository: LocalTokenRepository,
) : BaseApiResponse() {



    suspend fun singUp(user: AuthUser): NetworkResult<ApiToken> {

        val result = safeApiCall { iLogSingInApi.singUp(user) }

        result.data?.let {
            localTokenRepository.setRefreshToken(it.refreshToken)
            localTokenRepository.setAccessToken(it.accessToken)
        }
        return result
    }

    suspend fun logIn(user: AuthUser): NetworkResult<ApiToken> {

        val result = safeApiCall { iLogSingInApi.logIn(user) }

        result.data?.let {
            localTokenRepository.setRefreshToken(it.refreshToken)
            localTokenRepository.setAccessToken(it.accessToken)

            Log.d("TOKEN_REPA","${ it.accessToken}")
        }

        return result
    }



}