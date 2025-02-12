package com.example.dev2dev.di.models

import com.example.dev2dev.data.jwtToken.ILocalTokenRepository
import com.example.dev2dev.data.jwtToken.LocalTokenRepository
import com.example.dev2dev.data.api.auth.LogSingInApiRepository
import com.example.dev2dev.data.api.base.BaseApiRepository
import com.example.dev2dev.domain.interactor.auth.AuthInteractorImpl
import com.example.dev2dev.domain.interactor.auth.IAuthInteractor
import com.example.dev2dev.domain.interactor.Base.IBaseInteractor
import com.example.dev2dev.domain.interactor.Base.BaseInteractorImpl
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
    fun providesIAuthRepository(logSingInApiRepository: LogSingInApiRepository): IAuthInteractor {
        return AuthInteractorImpl(logSingInApiRepository)
    }

    @Provides
    @Singleton
    fun providesLocalTokenRepository(): ILocalTokenRepository {
        return LocalTokenRepository()
    }

    @Provides
    @Singleton
    fun providesIBaseRepository(baseApiRepository: BaseApiRepository): IBaseInteractor {
        return BaseInteractorImpl(baseApiRepository)
    }

}