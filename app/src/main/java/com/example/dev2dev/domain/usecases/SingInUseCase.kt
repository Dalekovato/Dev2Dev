package com.example.dev2dev.domain.usecases

import com.example.dev2dev.data.GeneralRepository
import com.example.dev2dev.data.api.dtoUser.AuthUser
import javax.inject.Inject

class SingInUseCase @Inject constructor(
    private val generalRepository: GeneralRepository
) {

    suspend fun invoke(user: AuthUser) = generalRepository.singIn(user)
}