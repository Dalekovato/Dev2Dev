package com.example.dev2dev.data.api

import com.example.dev2dev.data.api.dtoUser.AuthUser
import javax.inject.Inject

class LogSingInApiRepository @Inject constructor(
    private val iLogSingInApi: ILogSingApiService,
) {

    suspend fun singUp(user: AuthUser) = iLogSingInApi.singUp(user)

    suspend fun singIn(user: AuthUser) = iLogSingInApi.singIn(user)

}