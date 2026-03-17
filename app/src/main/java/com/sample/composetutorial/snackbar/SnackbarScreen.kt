package com.sample.composetutorial.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

// Basic Snackbar
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BasicSnackbar() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Snackbar Tutorial") })
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Simple Snackbar
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "This is a simple snackbar"
                    )
                }
            }) {
                Text("Show Simple Snackbar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Snackbar with Action
            Button(onClick = {
                scope.launch {
                    val result = snackbarHostState.showSnackbar(
                        message = "Item deleted",
                        actionLabel = "Undo",
                        duration = SnackbarDuration.Short
                    )
                    when (result) {
                        SnackbarResult.ActionPerformed -> {
                            // Handle undo action
                        }
                        SnackbarResult.Dismissed -> {
                            // Snackbar was dismissed
                        }
                    }
                }
            }) {
                Text("Show Snackbar with Action")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Long Duration Snackbar
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "This snackbar has a longer duration",
                        duration = SnackbarDuration.Long,
                        withDismissAction = true
                    )
                }
            }) {
                Text("Show Long Snackbar")
            }
        }
    }
}
