package com.example.dev2dev.di.models

import android.text.TextUtils
import android.util.Log
import com.example.dev2dev.data.api.main.IMainService
import com.example.dev2dev.data.api.main.MainApiRepository
import com.example.dev2dev.data.jwtToken.LocalTokenRepository
import com.example.dev2dev.utils.Helper
import com.example.dev2dev.utils.MissingAccessTokenException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainApiModule {

    @Singleton
    @Provides
    @Named("Main")
    fun prividesHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    @Named("Main")
    fun providesOkHttpClient(
        localTokenRepository: LocalTokenRepository,
        mainApiRepository: MainApiRepository,
        @Named("Main") httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()
                val accessToken = localTokenRepository.getAccessToken()
                val refreshToken = localTokenRepository.getRefreshToken()

                if (TextUtils.isEmpty(accessToken)) {
                    throw MissingAccessTokenException("Access token is missing")
                } else {
                    requestBuilder.addHeader("Authorization", "Bearer $accessToken")
                }

                val response = chain.proceed(requestBuilder.build())
                // Проверяем, не истек ли токен
                if (response.code == 401 ) {

                    Log.d("OkHttpInterceptor", "Token expired, attempting to refresh...")

                    // Попробуем обновить токен
                    val newToken = runBlocking {
                        mainApiRepository.refreshToken(refreshToken)
                    }
                    if (newToken.isSuccessful) {
                        newToken.body()?.let { tokenResponse ->
                            localTokenRepository.setAccessToken(tokenResponse.accessToken)
                            localTokenRepository.setRefreshToken(tokenResponse.refreshToken)

                            requestBuilder.header("Authorization", "Bearer ${tokenResponse.accessToken}")
                            return@addInterceptor chain.proceed(requestBuilder.build())
                        } ?: throw MissingAccessTokenException("Failed to refresh access token")
                    } else {
                        throw MissingAccessTokenException("Failed to refresh token: ${newToken.message()}")
                    }
                }
                response // Возвращаем оригинальный ответ, если токен действителен
            }
            .build()


    @Singleton
    @Provides
    @Named("Main")
    fun providesRetrofit(@Named("Main")okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(Helper.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    @Named("Main")
    fun providesIMainApiService(@Named("Main")retrofit: Retrofit) = retrofit.create(IMainService::class.java)

}