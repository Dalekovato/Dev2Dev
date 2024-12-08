package com.example.dev2dev.domain.interactor

import com.example.dev2dev.data.api.LogSingInApiRepository
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.utils.NetworkResult
import javax.inject.Inject

class AuthInteractorImpl @Inject constructor(
    private val logSingInApiRepository: LogSingInApiRepository
): IAuthRepository {

    override suspend fun logIn(user: AuthUser): NetworkResult<ApiToken>{
        return logSingInApiRepository.logIn(user)
    }

    override suspend fun singUp(user: AuthUser): NetworkResult<ApiToken>{
        return logSingInApiRepository.singUp(user)
    }


}