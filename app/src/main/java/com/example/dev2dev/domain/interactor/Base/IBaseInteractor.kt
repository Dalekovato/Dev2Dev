package com.example.dev2dev.domain.interactor.Base

import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import com.example.dev2dev.domain.model.UserDataProfileDomain
import retrofit2.Response

interface IBaseInteractor {

    // Редактирование профиля
    suspend fun editProfile(userDataProfileDto: UserDataProfileDto): Response<UserDataProfileDomain>

    // Тестовое поле
    suspend fun testRoad(): Response<Unit>

}