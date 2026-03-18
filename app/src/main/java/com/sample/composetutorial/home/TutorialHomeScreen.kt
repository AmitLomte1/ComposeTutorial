package com.sample.composetutorial.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorialHomeScreen(onItemClick: (TutorialRoute) -> Unit) {

    val tutorialCategories = listOf(
        "Basic UI Elements" to listOf(
            TutorialRoute.Text,
            TutorialRoute.TextField,
            TutorialRoute.Button,
            TutorialRoute.Image,
            TutorialRoute.Card,
            TutorialRoute.Row,
            TutorialRoute.Box,
            TutorialRoute.Checkbox,
            TutorialRoute.RadioButton,
            TutorialRoute.Switch,
            TutorialRoute.Slider,
            TutorialRoute.FloatingActionButton,
            TutorialRoute.Chip,
            TutorialRoute.Badge,
            TutorialRoute.PasswordField,
            TutorialRoute.GoogleButton,
            TutorialRoute.GradientButton,
            TutorialRoute.ExpandableCard,
            TutorialRoute.CoilImage,
            TutorialRoute.HorizontalPager,
            TutorialRoute.VerticalPager
        ),
        "Lists" to listOf(
            TutorialRoute.LazyColumn,
            TutorialRoute.StickyHeader,
            TutorialRoute.LazyRow,
            TutorialRoute.LazyGrid
        ),
        "Navigation" to listOf(
            TutorialRoute.BottomNavigation,
            TutorialRoute.NestedNavGraph
        ),
        "Components" to listOf(
            TutorialRoute.AlertDialog,
            TutorialRoute.DropdownMenu,
            TutorialRoute.Scaffold,
            TutorialRoute.Snackbar,
            TutorialRoute.BottomSheet,
            TutorialRoute.TabRow,
            TutorialRoute.TopAppBar,
            TutorialRoute.Material3TopAppBar,
            TutorialRoute.CollapsingToolbar
        ),
        "Pickers" to listOf(
            TutorialRoute.DatePicker,
            TutorialRoute.TimePicker
        ),
        "Effects & Animations" to listOf(
            TutorialRoute.BlurScreen,
            TutorialRoute.LoadingAnimation,
            TutorialRoute.ShimmerEffect,
            TutorialRoute.ThemeSwitcher
        ),
        "Advanced" to listOf(
            TutorialRoute.BrowseImage,
            TutorialRoute.CircularShapeImage,
            TutorialRoute.CustomCanvas,
            TutorialRoute.CircularProgressBar,
            TutorialRoute.HyperLinkText,
            TutorialRoute.SelectableItem,
            TutorialRoute.MultiPreview,
            TutorialRoute.WebView,
            TutorialRoute.StopWatch,
            TutorialRoute.RequestPermission,
            TutorialRoute.SplashScreen
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Compose Tutorial") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            tutorialCategories.forEach { (category, tutorials) ->
                item {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
                    )
                }
                items(tutorials) { tutorial ->
                    Button(
                        onClick = { onItemClick(tutorial) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = tutorial.title)
                    }
                }
            }
        }
    }
}
