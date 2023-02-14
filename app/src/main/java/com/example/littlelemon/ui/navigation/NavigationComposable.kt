package com.example.littlelemon.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.data.PrefRepository
import com.example.littlelemon.ui.*

@Composable
fun Navigation(navController: NavHostController) {
    val prefRepository = PrefRepository(LocalContext.current)
    val startDestination =
        if (prefRepository.getLoggedIn()) Home.route else Onboarding.route

    NavHost(navController = navController, startDestination = startDestination ) {
        composable(Onboarding.route) {
            Onboarding(navController)
        }
        composable(Home.route) {
            Home(navController)
        }
        composable(Profile.route) {
            Profile()
        }
    }
}