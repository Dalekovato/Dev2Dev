package com.example.dev2dev.domain.interactor.auth

import com.example.dev2dev.data.api.dtoUser.ApiTokenDto
import com.example.dev2dev.data.api.dtoUser.AuthUserDto
import com.example.dev2dev.utils.NetworkResult

interface IAuthInteractor {

    suspend fun logIn(user: AuthUserDto): NetworkResult<ApiTokenDto>

    suspend fun singUp(user: AuthUserDto): NetworkResult<Unit>

}