package com.example.dev2dev.ui.authNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.dev2dev.ui.bottomNav.DefaultScreen
import com.example.dev2dev.ui.presentation.auth.singup.PolicyScreen
import com.example.dev2dev.ui.presentation.auth.singup.PrivacyScreen
import com.example.dev2dev.ui.presentation.auth.singup.SingUpScreen
import com.example.dev2dev.ui.presentation.login.LoginScreen

sealed class Route {
    data class LoginScreen(val name: String = "Login") : Route()
    data class SingUpScreen(val name: String = "SingUp") : Route()
    data class PrivacyScreen(val name: String = "Privacy") : Route()
    data class PolicyScreen(val name: String = "Policy") : Route()
    data class DefaultScreen(val name: String = "Default") : Route()
}

@Suppress("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyNavigation(
    navHostController: NavHostController,
    navBarController: NavHostController,
) {

    NavHost(
        navController = navHostController,
        startDestination = "login_flow"
    ) {

        navigation(startDestination = Route.LoginScreen().name, route = "login_flow") {
            composable(route = Route.LoginScreen().name) {
                LoginScreen(
                    onLoginClick = {
                        navHostController.navigate(
                            Route.DefaultScreen().name
                        ) {
                            popUpTo(route = "login_flow")
                        }
                    },
                    onSignUpClick = {
                        navHostController.navigateToSingleTop(
                            Route.SingUpScreen().name
                        )
                    }
                )
            }
            composable(route = Route.SingUpScreen().name) {
                SingUpScreen(
                    onLoginClick = {
                        navHostController.navigateToSingleTop(
                            Route.LoginScreen().name
                        )
                    },
                    onPrivacyClick = {
                        navHostController.navigate(
                            Route.PrivacyScreen().name
                        ) {
                            launchSingleTop = true
                        }
                    },
                    onPolicyClick = {
                        navHostController.navigate(
                            Route.PolicyScreen().name
                        ) {
                            launchSingleTop = true
                        }
                    },
                    onSingUpClick = {
                        navHostController.navigateToSingleTop(
                            Route.LoginScreen().name
                        )
                    }
                )
            }
            composable(route = Route.PrivacyScreen().name) {
                PrivacyScreen {
                    navHostController.navigateUp()
                }
            }
            composable(route = Route.PolicyScreen().name) {
                PolicyScreen {
                    navHostController.navigateUp()
                }
            }
        }

        composable(route = Route.DefaultScreen().name) {
            DefaultScreen(navBarController) {
                navHostController.navigateToSingleTop(Route.LoginScreen().name)
            }
        }

    }
}

fun NavController.navigateToSingleTop(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true   // Работаем со стеком очереди
        }
        launchSingleTop = true // делает один экземпляр главного экрана
        restoreState = true
    }
}