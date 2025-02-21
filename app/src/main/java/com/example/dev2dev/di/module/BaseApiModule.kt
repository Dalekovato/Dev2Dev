package com.example.dev2dev.di.module

import android.text.TextUtils
import android.util.Log
import com.example.dev2dev.data.api.auth.LogSingInApiRepository
import com.example.dev2dev.data.api.base.IBaseService
import com.example.dev2dev.data.jwtToken.ILocalTokenRepository
import com.example.dev2dev.utils.Helper
import com.example.dev2dev.utils.MissingAccessTokenException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BaseApiModule {

    @Singleton
    @Provides
    @Named("base")
    fun prividesHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    @Named("base")
    fun providesBaseOkHttpClient(
        localTokenRepository: ILocalTokenRepository,
        logSingInApiRepository: LogSingInApiRepository,
        @Named("base") httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()
                val accessToken = localTokenRepository.getAccessToken()
                Log.d("OkHttpInterceptor", "Access Token: $accessToken")
                val refreshToken = localTokenRepository.getRefreshToken()

                if (TextUtils.isEmpty(accessToken)) {
                    throw MissingAccessTokenException("Access token is missing")
                } else {
                    requestBuilder.addHeader("Authorization", "Bearer $accessToken")
                }

                val response = chain.proceed(requestBuilder.build())
                // Проверяем, не истек ли токен
                if (response.code == 401) {
                    Log.d("OkHttpInterceptor", "Token expired, attempting to refresh...")
                    response.close()
                    // Попробуем обновить токен
                    val newToken = runBlocking {
                        val authHeader = "Bearer $accessToken"
                        val json = JSONObject()
                        json.put("refresh_token", refreshToken)
                        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())

                        logSingInApiRepository.refreshToken(authHeader, requestBody)
                    }
                    if (newToken.isSuccessful) {
                        newToken.body()?.let { tokenResponse ->
                            localTokenRepository.setAccessToken(tokenResponse.accessToken)
                            localTokenRepository.setRefreshToken(tokenResponse.refreshToken)

                            requestBuilder.header("Authorization", "Bearer ${tokenResponse.accessToken}")
                            return@addInterceptor chain.proceed(requestBuilder.build())
                        } ?: throw MissingAccessTokenException("Failed to refresh access token")
                    } else {
                        Log.e("OkHttpInterceptor", "Failed to refresh token: ${newToken.message()}")
                        throw MissingAccessTokenException("Failed to refresh token: ${newToken.message()}") // переделать на выход к экрану авторизации
                    }
                }
                response // Возвращаем оригинальный ответ, если токен действителен
            }
            .build()

    @Singleton
    @Provides
    @Named("base")
    fun providesBaseRetrofit(@Named("base") okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(Helper.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun providesIBaseApiService(@Named("base") retrofit: Retrofit) = retrofit.create(IBaseService::class.java)

}