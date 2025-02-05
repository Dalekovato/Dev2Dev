package com.example.dev2dev.domain.interactor.auth

import com.example.dev2dev.data.api.auth.LogSingInApiRepository
import com.example.dev2dev.data.api.dtoUser.ApiTokenDto
import com.example.dev2dev.data.api.dtoUser.AuthUserDto
import com.example.dev2dev.utils.NetworkResult
import javax.inject.Inject

class AuthInteractorImpl @Inject constructor(
    private val logSingInApiRepository: LogSingInApiRepository,
) : IAuthInteractor {

    override suspend fun logIn(user: AuthUserDto): NetworkResult<ApiTokenDto> {
        return logSingInApiRepository.logIn(user)
    }

    override suspend fun singUp(user: AuthUserDto): NetworkResult<ApiTokenDto> {
        return logSingInApiRepository.singUp(user)
    }

}