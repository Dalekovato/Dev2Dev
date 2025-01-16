package com.example.dev2dev.ui.bottomNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dev2dev.ui.presentation.chat.ChatScreen
import com.example.dev2dev.ui.presentation.home.HomeScreen
import com.example.dev2dev.ui.presentation.profile.ProfileScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    onLoginClick: () -> Unit,
) {

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen {
                onLoginClick()
            }
        }

        composable(route = BottomBarScreen.Chat.route) {
            ChatScreen()
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
    }
}