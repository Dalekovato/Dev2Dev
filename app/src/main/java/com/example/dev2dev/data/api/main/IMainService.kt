package com.example.dev2dev.data.api.main

import com.example.dev2dev.data.api.dtoUser.ApiTokenDto
import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IMainService {

    @POST("/auth/refresh-token") //Обновление access-токена
    suspend fun refreshToken(@Body refreshToken: String):Response<ApiTokenDto>

    @GET("/protected") // Редактирование профиля
    suspend fun editProfile(@Body userDataProfileDto: UserDataProfileDto):Response<UserDataProfileDto>

    @GET("/protected")  // Тестовое поле
    suspend fun testRoad()


}