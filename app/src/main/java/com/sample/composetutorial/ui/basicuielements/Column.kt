package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sample.composetutorial.ui.theme.ComposeTutorialTheme

// Custom Item with Extension function
@Composable
fun RowScope.CustomItem(weight: Float, color: Color = MaterialTheme.colorScheme.primary) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .weight(weight), color = color
    ) {

    }
}

// Row
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            CustomItem(weight = 1f, color = MaterialTheme.colorScheme.error)
            CustomItem(weight = 1f, color = MaterialTheme.colorScheme.background)
            CustomItem(weight = 1f)
        }
    }
}