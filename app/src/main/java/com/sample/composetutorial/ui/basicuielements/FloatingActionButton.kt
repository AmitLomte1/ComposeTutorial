package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// All FAB types
@Preview(showBackground = true)
@Composable
fun AllFabTypes() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Small FAB
        SmallFloatingActionButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Regular FAB
        FloatingActionButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Large FAB
        LargeFloatingActionButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Extended FAB
        ExtendedFloatingActionButton(
            onClick = { },
            icon = { Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit") },
            text = { Text(text = "Compose") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Custom Color FAB
        FloatingActionButton(
            onClick = { },
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    }
}
