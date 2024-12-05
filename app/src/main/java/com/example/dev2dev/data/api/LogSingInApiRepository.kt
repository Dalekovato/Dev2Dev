package com.example.dev2dev.data.api

import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import retrofit2.Response
import javax.inject.Inject

class LogSingInApiRepository @Inject constructor(
    private val iLogSingInApi: ILogSingApiService,  
) {

    suspend fun singUp(user: AuthUser):Response<ApiToken> {
        return iLogSingInApi.singUp(user)
    }

    suspend fun singIn(user: AuthUser):Response<ApiToken>  {
        return iLogSingInApi.singIn(user)
    }

}