package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Basic Row
@Preview(showBackground = true)
@Composable
fun BasicRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
    }
}

// Row with weighted children
@Preview(showBackground = true)
@Composable
fun WeightedRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Weight 1",
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
                .padding(8.dp)
        )
        Text(
            text = "Weight 2",
            modifier = Modifier
                .weight(2f)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f))
                .padding(8.dp)
        )
        Text(
            text = "Weight 1",
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f))
                .padding(8.dp)
        )
    }
}

// Row with different arrangements
@Preview(showBackground = true)
@Composable
fun RowArrangements() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Start",
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = "Center",
            modifier = Modifier.size(70.dp)
        )
        Text(
            text = "End",
            modifier = Modifier.size(50.dp)
        )
    }
}
