package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Basic Checkbox
@Preview(showBackground = true)
@Composable
fun BasicCheckbox() {
    var checked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (checked) "Checked" else "Unchecked")
        }
    }
}

// Checkbox with custom colors
@Preview(showBackground = true)
@Composable
fun CustomColorCheckbox() {
    var checked by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.error,
                uncheckedColor = MaterialTheme.colorScheme.outline,
                checkmarkColor = MaterialTheme.colorScheme.onError
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Custom Color Checkbox")
    }
}

// Checkbox Group
@Preview(showBackground = true)
@Composable
fun CheckboxGroup() {
    val items = listOf("Option 1", "Option 2", "Option 3")
    val checkedStates = remember { mutableStateOf(List(items.size) { false }) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Select Options:",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        items.forEachIndexed { index, item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedStates.value[index],
                    onCheckedChange = { isChecked ->
                        checkedStates.value = checkedStates.value.toMutableList().also {
                            it[index] = isChecked
                        }
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item)
            }
        }
    }
}

// TriState Checkbox
@Preview(showBackground = true)
@Composable
fun TriStateCheckboxDemo() {
    var state by remember { mutableStateOf(ToggleableState.Off) }
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TriStateCheckbox(
            state = state,
            onClick = {
                state = when (state) {
                    ToggleableState.Off -> ToggleableState.Indeterminate
                    ToggleableState.Indeterminate -> ToggleableState.On
                    ToggleableState.On -> ToggleableState.Off
                }
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "TriState: $state")
    }
}
