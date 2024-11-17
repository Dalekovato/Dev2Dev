package com.example.dev2dev.data.api

import com.example.dev2dev.data.api.dtoUser.User
import javax.inject.Inject

class LogSingInApiRepository @Inject constructor(
    private val iLogSingInApi: ILogSingApiService,
) {

    suspend fun singUp(user: User) = iLogSingInApi.singUp(user)

    suspend fun singIn(user: User) = iLogSingInApi.singIn(user)

}