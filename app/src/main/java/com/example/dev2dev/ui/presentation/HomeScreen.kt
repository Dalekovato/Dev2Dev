package com.example.dev2dev.ui.presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dev2dev.data.Jwt.LocalTokenRepository
import com.example.dev2dev.ui.presentation.auth.AuthViewModel

@Composable
fun HomeScreen() {

    val authViewModel: AuthViewModel = hiltViewModel()

    // Подписываемся на значения StateFlow
    val refreshToken by authViewModel.refreshToken.collectAsState()
    val accessToken by authViewModel.accessToken.collectAsState()

    // Вызываем обновление токенов при переходе на экран
    LaunchedEffect(Unit) {
        authViewModel.updateTokens()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "refresh: $refreshToken\naccess: $accessToken")
    }

}