package com.sample.composetutorial.sharedatabetweenscreen.navgraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sample.composetutorial.navigation.model.Screen
import com.sample.composetutorial.sharedatabetweenscreen.model.Person
import com.sample.composetutorial.sharedatabetweenscreen.screen.details.ParcelableDetailScreen
import com.sample.composetutorial.sharedatabetweenscreen.screen.home.ParcelableHomeScreen
import com.sample.composetutorial.sharedatabetweenscreen.viewmodel.SharedViewModel

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            ParcelableHomeScreen(navHostController, sharedViewModel)
        }
        composable(
            route = Screen.Detail.route
        ) {
            val personResult =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
            ParcelableDetailScreen(navHostController, sharedViewModel)
        }
    }
}