package com.sample.composetutorial.sharedatabetweenscreen.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sample.composetutorial.navigation.model.Screen
import com.sample.composetutorial.sharedatabetweenscreen.model.Person
import com.sample.composetutorial.sharedatabetweenscreen.viewmodel.SharedViewModel

@Composable
fun ParcelableHomeScreen(
    navController: NavController, viewModel: SharedViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.clickable {
                val person = Person(
                    firstName = "ABC", lastName = "JKL"
                )
                viewModel.addPerson(person)
//                navController.currentBackStackEntry?.savedStateHandle?.set(
//                    key = "person", value = person
//                )
                navController.navigate(Screen.Detail.route)
            },
            text = "Home",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ParcelableHomeScreenPreview() {
    ParcelableHomeScreen(
        navController = rememberNavController(), viewModel = SharedViewModel()
    )
}