package com.example.dev2dev.data

import com.example.dev2dev.data.api.LogSingInApiRepository
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.utils.BaseApiResponse
import com.example.dev2dev.utils.NetworkResult
import javax.inject.Inject

class GeneralRepository @Inject constructor(

    private val logSingInApiRepository: LogSingInApiRepository ,


): BaseApiResponse() {

    suspend fun singUp(user: AuthUser): NetworkResult<ApiToken> {
        return safeApiCall { logSingInApiRepository.singUp(user)}
    }

    suspend fun singIn(user: AuthUser) : NetworkResult<ApiToken> {
        return safeApiCall { logSingInApiRepository.singIn(user) }
    }




}