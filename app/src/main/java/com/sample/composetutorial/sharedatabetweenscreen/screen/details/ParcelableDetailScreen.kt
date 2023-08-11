package com.sample.composetutorial.sharedatabetweenscreen.screen.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sample.composetutorial.navigation.model.Screen
import com.sample.composetutorial.sharedatabetweenscreen.viewmodel.SharedViewModel

@Composable
fun ParcelableDetailScreen(
    navController: NavController, sharedViewModel: SharedViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            },
            text = sharedViewModel.person.firstName + sharedViewModel.person.lastName,
            color = Color.Red,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ParcelableDetailScreenPreview() {
    ParcelableDetailScreen(rememberNavController(), SharedViewModel())
}