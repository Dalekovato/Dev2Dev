package com.example.dev2dev.domain.interactor

import com.example.dev2dev.data.GeneralRepository
import com.example.dev2dev.data.Jwt.JwtTokenDataStore
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.utils.NetworkResult
import javax.inject.Inject

class AuthInteractorImpl @Inject constructor(
    private val generalRepository: GeneralRepository,
    private val jwtTokenDataStore: JwtTokenDataStore,
): IAuthInteractor {

    override suspend fun singIn(user: AuthUser): NetworkResult<ApiToken>{
        return generalRepository.singIn(user)
    }

    override suspend fun singUn(user: AuthUser): NetworkResult<ApiToken>{
        return generalRepository.singUp(user)
    }

    override suspend fun saveToken(token: ApiToken){
        jwtTokenDataStore.saveRefreshJwt(token.refreshToken)
        jwtTokenDataStore.saveAccessJwt(token.accessToken)
    }

    override suspend fun getAccessToken():String{
        return jwtTokenDataStore.getAccessJwt().toString()
    }

    override suspend fun getRefreshToken():String{
        return jwtTokenDataStore.getRefreshJwt().toString()
    }

    override suspend fun clearToken(){
        return jwtTokenDataStore.clearAllTokens()
    }

}