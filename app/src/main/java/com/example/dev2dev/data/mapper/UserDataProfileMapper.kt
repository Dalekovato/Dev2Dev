package com.example.dev2dev.data.mapper

import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import com.example.dev2dev.data.model.UserDataProfileDomain

class UserDataProfileMapper(userDataProfileDto: UserDataProfileDto?) {

    val userProfile by lazy {
        UserDataProfileDomain(
            nickname = userDataProfileDto?.nickname.orEmpty(),
        )

    }
}