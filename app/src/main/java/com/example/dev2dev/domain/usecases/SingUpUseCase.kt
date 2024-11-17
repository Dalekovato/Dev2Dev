package com.example.dev2dev.domain.usecases

import com.example.dev2dev.data.GeneralRepository
import com.example.dev2dev.data.api.dtoUser.User
import javax.inject.Inject

class SingUpUseCase @Inject constructor(
    private val generalRepository: GeneralRepository
) {

    suspend fun invoke(user: User) = generalRepository.singUp(user)

}