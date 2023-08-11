package com.sample.composetutorial.splashscreen.navgraph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sample.composetutorial.navigation.model.Screen
import com.sample.composetutorial.splashscreen.AnimatedSplashScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            AnimatedSplashScreen(navController)
        }
        composable(
            route = Screen.Detail.route
        ) {
            Box(modifier = Modifier.fillMaxSize())
        }
    }
}