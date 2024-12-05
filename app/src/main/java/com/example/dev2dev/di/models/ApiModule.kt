package com.example.dev2dev.di.models

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.dev2dev.data.Jwt.JwtTokenDataStore
import com.example.dev2dev.data.Jwt.JwtTokenManager
import com.example.dev2dev.data.api.ILogSingApiService
import com.example.dev2dev.domain.interactor.AuthInteractorImpl
import com.example.dev2dev.domain.interactor.IAuthInteractor
import com.example.dev2dev.utils.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val BASE_URL = "http://150.241.83.123:8081"

    @Singleton
    @Provides
    fun prividesHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpKlient(httpLogingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLogingInterceptor)
            .build()  // гдето-тут добавить токен

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun providesILogSingApiService(retrofit: Retrofit) = retrofit.create(ILogSingApiService::class.java)


    @Singleton
    @Provides
    fun providesDataStorePreference (@ApplicationContext context: Context):DataStore<Preferences>{
        return context.dataStore
    }

    @Singleton
    @Provides
    fun providesDataStoreManager (dataStore:DataStore<Preferences>):JwtTokenDataStore{
        return JwtTokenDataStore(dataStore )
    }



}