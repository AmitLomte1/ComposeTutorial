package com.sample.composetutorial.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sample.composetutorial.navigation.model.Screen

@Composable
fun LoginScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Detail.passId(19))
            },
            text = "Login",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(150.dp)
                .clickable {

                },
            text = "Go Back",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController()
    )
}