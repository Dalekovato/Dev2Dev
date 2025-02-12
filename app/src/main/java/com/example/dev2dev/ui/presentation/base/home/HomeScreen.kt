package com.example.dev2dev.ui.presentation.base.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dev2dev.ui.presentation.auth.AuthViewModel
import com.example.dev2dev.ui.presentation.base.BaseViewModel

@Composable
fun HomeScreen(
    onLoginClick: () -> Unit,
) {

    val authViewModel: AuthViewModel = hiltViewModel()
    val baseViewModel: BaseViewModel = hiltViewModel()
    // Подписываемся на значения StateFlow
    val refreshToken by authViewModel.refreshToken.collectAsState()
    val accessToken by authViewModel.accessToken.collectAsState()

    // Вызываем обновление токенов при переходе на экран
    LaunchedEffect(Unit) {
        authViewModel.updateTokens()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "refresh: $refreshToken\naccess: $accessToken")

            Button(
                onClick = {
                    baseViewModel.testRoad()
                }
            ) {
                Text(text = "TestRoad")
            }

            Button(
                onClick = {
                    onLoginClick()
                }
            ) {
                Text(text = "Back")
            }
        }

    }

}