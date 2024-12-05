package com.example.dev2dev.di.models

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.dev2dev.utils.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

//    Позже нужно будет

//    @Singleton
//    @Provides
//    fun providesDataStorePreference (@ApplicationContext context: Context): DataStore<Preferences> {
//        return context.dataStore
//    }
//
//    @Singleton
//    @Provides
//    fun providesDataStoreManager (dataStore: DataStore<Preferences>): JwtTokenDataStore {
//        return JwtTokenDataStore(dataStore )
//    }
}