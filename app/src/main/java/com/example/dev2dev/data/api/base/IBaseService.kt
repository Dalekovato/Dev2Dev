package com.example.dev2dev.data.api.base

import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface IBaseService {

    @GET("/protected") // Редактирование профиля
    suspend fun editProfile(@Body userDataProfileDto: UserDataProfileDto): Response<UserDataProfileDto>

    @GET("/protected")  // Тестовое поле
    suspend fun testRoad(): Response<Unit>

}