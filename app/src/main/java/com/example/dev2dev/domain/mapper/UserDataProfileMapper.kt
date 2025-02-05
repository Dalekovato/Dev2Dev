package com.example.dev2dev.domain.mapper

import com.example.dev2dev.data.api.dtoUser.UserDataProfileDto
import com.example.dev2dev.domain.model.UserDataProfileDomain

class UserDataProfileMapper(userDataProfileDto: UserDataProfileDto?) {

    val userProfile by lazy {
        UserDataProfileDomain(
            nickname = userDataProfileDto?.nickname.orEmpty(),
        )

    }
}