package com.example.dev2dev.data.api.main

import com.example.dev2dev.data.api.dtoUser.ApiTokenDto
import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import com.example.dev2dev.domain.mapper.UserDataProfileMapper
import com.example.dev2dev.domain.model.UserDataProfileDomain
import retrofit2.Response
import javax.inject.Inject

class MainApiRepository @Inject constructor(
    private val iMainService: IMainService,
) {

    suspend fun refreshToken(refreshToken: String):Response<ApiTokenDto>{
       return iMainService.refreshToken(refreshToken)
    }

    suspend fun editProfile(userDataProfileDto: UserDataProfileDto): Response<UserDataProfileDomain>{

        val response = iMainService.editProfile(userDataProfileDto)

        return  Response.success(
            UserDataProfileMapper(
                response.body() ?: UserDataProfileDto("Null")
            ).userProfile
        )
    }

    suspend fun testRoad(){
        iMainService.testRoad()
    }

}