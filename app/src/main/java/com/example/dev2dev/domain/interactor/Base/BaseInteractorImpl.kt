package com.example.dev2dev.domain.interactor.Base

import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import com.example.dev2dev.data.api.base.BaseApiRepository
import com.example.dev2dev.domain.model.UserDataProfileDomain
import retrofit2.Response
import javax.inject.Inject

class BaseInteractorImpl @Inject constructor(
    private val baseApiRepository: BaseApiRepository,
) : IBaseInteractor {

    override suspend fun editProfile(userDataProfileDto: UserDataProfileDto): Response<UserDataProfileDomain> {
        return baseApiRepository.editProfile(userDataProfileDto)
    }

    override suspend fun testRoad(): Response<Unit> {
        return baseApiRepository.testRoad()
    }

}