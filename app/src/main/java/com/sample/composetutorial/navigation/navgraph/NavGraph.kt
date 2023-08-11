package com.sample.composetutorial.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sample.composetutorial.navigation.DetailScreen
import com.sample.composetutorial.navigation.HomeScreen
import com.sample.composetutorial.navigation.model.Screen

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController, startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            HomeScreen(navHostController)
        }
        composable(
            route = Screen.Detail.route
        ) {
            val argument = it.arguments?.getInt("id")
            DetailScreen(navHostController, argument)
        }
    }
}