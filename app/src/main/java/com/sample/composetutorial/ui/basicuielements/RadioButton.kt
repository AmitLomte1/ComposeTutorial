package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Basic RadioButton
@Preview(showBackground = true)
@Composable
fun BasicRadioButton() {
    var selected by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected,
                onClick = { selected = !selected }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (selected) "Selected" else "Not Selected")
        }
    }
}

// RadioButton Group
@Preview(showBackground = true)
@Composable
fun RadioButtonGroup() {
    val options = listOf("Option A", "Option B", "Option C")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Choose an option:",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = (option == selectedOption),
                        onClick = { selectedOption = option },
                        role = Role.RadioButton
                    )
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Selected: $selectedOption")
    }
}

// Custom Color RadioButton
@Preview(showBackground = true)
@Composable
fun CustomRadioButton() {
    var selected by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = { selected = !selected },
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.error,
                unselectedColor = MaterialTheme.colorScheme.outline
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Custom Color RadioButton")
    }
}
