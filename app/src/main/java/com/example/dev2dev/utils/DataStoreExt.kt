package com.example.dev2dev.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

const val SERIAL_DECODER_DATA_STORE_NAME = "serialDecoderPreferenceDataStore"

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("SERIAL_DECODER_DATA_STORE_NAME")