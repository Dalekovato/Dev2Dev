package com.example.dev2dev.data.api.auth

import android.util.Log
import com.example.dev2dev.data.api.dtoUser.ApiTokenDto
import com.example.dev2dev.data.api.dtoUser.AuthUserDto
import com.example.dev2dev.data.jwtToken.ILocalTokenRepository
import com.example.dev2dev.utils.BaseApiResponse
import com.example.dev2dev.utils.NetworkResult
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject

class LogSingInApiRepository @Inject constructor(
    private val iLogSingInApi: ILogSingApiService,
    private val localTokenRepository: ILocalTokenRepository,
): BaseApiResponse() {

    suspend fun singUp(user: AuthUserDto): NetworkResult<Unit> {

        val result = safeApiCall { iLogSingInApi.singUp(user) }
        return result
    }

    suspend fun logIn(user: AuthUserDto): NetworkResult<ApiTokenDto> {

        val result = safeApiCall { iLogSingInApi.logIn(user) }

        result.data?.let {
            localTokenRepository.setRefreshToken(it.refreshToken)
            localTokenRepository.setAccessToken(it.accessToken)

            Log.d("TOKEN_REPO", "${it.accessToken}")
        }
        return result
    }

    suspend fun refreshToken(accessToken: String, refreshToken: RequestBody): Response<ApiTokenDto> {
        return iLogSingInApi.refreshToken(accessToken, refreshToken)
    }
}