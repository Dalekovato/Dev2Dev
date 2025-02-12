package com.example.dev2dev.data.api.auth

import com.example.dev2dev.data.api.dtoUser.ApiTokenDto
import com.example.dev2dev.data.api.dtoUser.AuthUserDto
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ILogSingApiService {

    @POST("/auth/sign-up") //Регистрация
    suspend fun singUp(@Body user: AuthUserDto): Response<Unit>

    @POST("/auth/sign-in") //Авторизация
    suspend fun logIn(@Body user: AuthUserDto): Response<ApiTokenDto>

    @POST("/auth/logout") //Выход из учетки
    suspend fun logOut()

    @POST("/auth/refresh-token") //Обновление access-токена
    suspend fun refreshToken(
        @Header("Authorization") accessToken: String,
        @Body refreshToken: RequestBody,
    ): Response<ApiTokenDto>

}



