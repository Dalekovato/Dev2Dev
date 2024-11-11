package com.example.dev2dev.data

import com.example.dev2dev.data.dtoUser.Token
import com.example.dev2dev.data.dtoUser.User
import retrofit2.http.Body
import retrofit2.http.POST

interface ILogSingInApi {

    @POST("/auth/sign-up")//Регистрация
    suspend fun SingUn(@Body user: User):Token

    @POST("/auth/sign-in")//Авторизация
    suspend fun SingIn():Token

    @POST("/auth/refresh-token")//Обновление access-токена
    suspend fun RefreshToken():Token

    @POST("/auth/logout")//Выход
    suspend fun LogOut()

}