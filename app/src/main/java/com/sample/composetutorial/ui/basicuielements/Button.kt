package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Basic Button
@Preview(showBackground = true)
@Composable
fun BasicButton() {
    var clickCount by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { clickCount++ }) {
            Text(text = "Clicked $clickCount times")
        }
    }
}

// All Button types
@Preview(showBackground = true)
@Composable
fun AllButtonTypes() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Filled Button
        Button(onClick = { }) {
            Text(text = "Filled Button")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Outlined Button
        OutlinedButton(onClick = { }) {
            Text(text = "Outlined Button")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Text Button
        TextButton(onClick = { }) {
            Text(text = "Text Button")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Elevated Button
        ElevatedButton(onClick = { }) {
            Text(text = "Elevated Button")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Filled Tonal Button
        FilledTonalButton(onClick = { }) {
            Text(text = "Filled Tonal Button")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Icon Button
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Button with Icon
        Button(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Add to Cart")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Disabled Button
        Button(onClick = { }, enabled = false) {
            Text(text = "Disabled Button")
        }

        // Custom Color Button
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError
            )
        ) {
            Text(text = "Custom Color Button")
        }
    }
}
