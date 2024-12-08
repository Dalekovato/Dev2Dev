package com.example.dev2dev.di.models

import com.example.dev2dev.data.api.ILogSingApiService
import com.example.dev2dev.data.jwtToken.ILocalTokenRepository
import com.example.dev2dev.data.jwtToken.LocalTokenRepository
import com.example.dev2dev.data.api.LogSingInApiRepository
import com.example.dev2dev.domain.interactor.AuthInteractorImpl
import com.example.dev2dev.domain.interactor.IAuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthRepositoryModule {


    @Provides
    @Singleton
    fun providesIAuthRepository(logSingInApiRepository: LogSingInApiRepository): IAuthRepository {
        return AuthInteractorImpl(logSingInApiRepository)
    }


    @Provides
    @Singleton
     fun providesLocalTokenRepository(): ILocalTokenRepository {
        return LocalTokenRepository()
    }


}