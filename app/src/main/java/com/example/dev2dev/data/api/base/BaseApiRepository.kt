package com.example.dev2dev.data.api.base

import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import com.example.dev2dev.data.mapper.UserDataProfileMapper
import com.example.dev2dev.data.model.UserDataProfileDomain
import retrofit2.Response
import javax.inject.Inject

class BaseApiRepository @Inject constructor(
    private val iBaseService: IBaseService,
) {

    suspend fun editProfile(userDataProfileDto: UserDataProfileDto): Response<UserDataProfileDomain> {

        val response = iBaseService.editProfile(userDataProfileDto)

        return Response.success(
            UserDataProfileMapper(
                response.body() ?: UserDataProfileDto("Null")
            ).userProfile
        )
    }

    suspend fun testRoad(): Response<Unit> {
        return iBaseService.testRoad()
    }

}