package com.example.dev2dev.domain.interactor.main

import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import com.example.dev2dev.data.api.main.MainApiRepository
import com.example.dev2dev.domain.model.UserDataProfileDomain
import retrofit2.Response
import javax.inject.Inject

class MainInteractorImpl @Inject constructor(
    private val mainApiRepository : MainApiRepository,
):IMainInteractor {

    override suspend fun editProfile(userDataProfileDto: UserDataProfileDto): Response<UserDataProfileDomain> {
        return mainApiRepository.editProfile(userDataProfileDto)
    }

    override suspend fun testRoad() {
        mainApiRepository.testRoad()
    }

}