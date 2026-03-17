package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// All Chip Types
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun AllChipTypes() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Assist Chips", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))

        // Assist Chip
        AssistChip(
            onClick = { },
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person",
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Elevated Assist Chip
        ElevatedAssistChip(
            onClick = { },
            label = { Text("Elevated Assist Chip") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Filter Chips", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))

        // Filter Chips
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val filters = listOf("Kotlin", "Java", "Dart", "Swift")
            filters.forEach { filter ->
                var selected by remember { mutableStateOf(false) }
                FilterChip(
                    selected = selected,
                    onClick = { selected = !selected },
                    label = { Text(filter) },
                    leadingIcon = if (selected) {
                        {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = "Selected",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else null
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Input Chip", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))

        // Input Chip
        var inputChipVisible by remember { mutableStateOf(true) }
        if (inputChipVisible) {
            InputChip(
                selected = false,
                onClick = { inputChipVisible = false },
                label = { Text("Input Chip") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Remove",
                        modifier = Modifier.size(InputChipDefaults.IconSize)
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Suggestion Chip", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))

        // Suggestion Chip
        SuggestionChip(
            onClick = { },
            label = { Text("Suggestion Chip") }
        )
    }
}
