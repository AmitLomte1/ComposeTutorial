package com.sample.composetutorial.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sample.composetutorial.navigation.navgraph.SetUpNavGraph
import com.sample.composetutorial.ui.theme.ComposeTutorialTheme
import com.sample.composetutorial.ui.toolbar.CentralizedToolBar

class NavigationActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                navController = rememberNavController()
                CentralizedToolBar()
                SetUpNavGraph(navHostController = navController)
            }
        }
    }
}