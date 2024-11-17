package com.example.dev2dev.data

import com.example.dev2dev.data.api.LogSingInApiRepository
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.User
import com.example.dev2dev.utils.BaseApiResponse
import com.example.dev2dev.utils.NetworkResult
import javax.inject.Inject

class GeneralRepository @Inject constructor(

    private val logSingInApiRepository: LogSingInApiRepository

): BaseApiResponse() {

    suspend fun singUp(user: User): NetworkResult<ApiToken> {
        return safeApiCall { logSingInApiRepository.singUp(user)}
    }

    suspend fun singIn(user: User) : NetworkResult<ApiToken> {
        return safeApiCall { logSingInApiRepository.singIn(user) }
    }


}