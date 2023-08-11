package com.sample.composetutorial.bottomnavigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sample.composetutorial.bottomnavigation.model.BottomBarScreen
import com.sample.composetutorial.bottomnavigation.screen.screens.HomeScreen
import com.sample.composetutorial.bottomnavigation.screen.screens.ProfileScreen
import com.sample.composetutorial.bottomnavigation.screen.screens.SettingScreen

@Composable
fun BottomNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController, startDestination = BottomBarScreen.Home.route
    ) {
        composable(
            route = BottomBarScreen.Home.route
        ) {
            HomeScreen()
        }
        composable(
            route = BottomBarScreen.Profile.route
        ) {
            ProfileScreen()
        }
        composable(
            route = BottomBarScreen.Setting.route
        ) {
            SettingScreen()
        }
    }
}