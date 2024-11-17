package com.example.dev2dev.data.api

import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ILogSingApiService {

    @POST("/auth/sign-up")//Регистрация
    suspend fun singUp(@Body user: User): Response<ApiToken>

    @POST("/auth/sign-in")//Авторизация
    suspend fun singIn(@Body user: User):Response<ApiToken>

    @POST("/auth/refresh-token")//Обновление access-токена
    suspend fun refreshToken():Response<ApiToken>

    @POST("/auth/logout")//Выход из учетки
    suspend fun logOut()

}



