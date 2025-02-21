package com.example.dev2dev.di.module

import com.example.dev2dev.data.api.auth.ILogSingApiService
import com.example.dev2dev.utils.Helper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    @Named("auth")
    fun prividesHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    @Named("auth")
    fun providesAuthOkHttpClient(@Named("auth") httpLogingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLogingInterceptor)
            .build()

    @Singleton
    @Provides
    @Named("auth")
    fun providesAuthRetrofit(@Named("auth") okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Helper.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun providesILogSingApiService(@Named("auth") retrofit: Retrofit) = retrofit.create(ILogSingApiService::class.java)

}