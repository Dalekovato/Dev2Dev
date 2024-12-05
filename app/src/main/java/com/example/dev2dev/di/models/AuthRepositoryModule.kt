package com.example.dev2dev.di.models

import com.example.dev2dev.data.api.LogSingInApiRepository
import com.example.dev2dev.domain.interactor.AuthInteractorImpl
import com.example.dev2dev.domain.interactor.IAuthRepository
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

}