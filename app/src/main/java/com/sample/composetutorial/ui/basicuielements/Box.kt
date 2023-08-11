package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Box
@Composable
fun Greetings() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.error),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .background(MaterialTheme.colorScheme.onPrimary)
            )
            androidx.compose.material3.Text(
                text = "Hello I am AMIT KUMAR Your new neighbour ",
                fontSize = 40.sp
            )
        }
    }
}