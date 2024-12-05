package com.example.dev2dev.ui.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dev2dev.ui.presentation.auth.AuthViewModel

@Composable
fun HomeScreen(
    authViewModel: AuthViewModel = viewModel(),
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "refresh :${authViewModel.getRefreshToken()} \n access:${authViewModel.getAccessToken()} ")
    }
}