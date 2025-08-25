package com.aliahmed.techtasktemplate.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.aliahmed.techtasktemplate.presentation.screens.Home
import com.aliahmed.techtasktemplate.presentation.screens.homeScreen
import kotlinx.serialization.Serializable

@Serializable
object TechTask

@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = TechTask) {
        navigation<TechTask>(Home) {
            homeScreen()
        }
    }
}
