package com.example.dev2dev.data.api

import com.example.dev2dev.data.Jwt.LocalTokenRepository
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.utils.BaseApiResponse
import com.example.dev2dev.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class LogSingInApiRepository @Inject constructor(
    private val iLogSingInApi: ILogSingApiService,
    private val localTokenRepository: LocalTokenRepository,
) : BaseApiResponse() {

    suspend fun singUp(user: AuthUser): NetworkResult<ApiToken> {

        val result = safeApiCall { iLogSingInApi.singUp(user) }

        result.data?.let {
            localTokenRepository.setRefreshToken(it.refreshToken)
            localTokenRepository.setRAccessToken(it.accessToken)
        }
        return result
    }

    suspend fun singIn(user: AuthUser): NetworkResult<ApiToken> {

        val result = safeApiCall { iLogSingInApi.singIn(user) }

        result.data?.let {
            localTokenRepository.setRefreshToken(it.refreshToken)
            localTokenRepository.setRAccessToken(it.accessToken)
        }
        return result
    }

}