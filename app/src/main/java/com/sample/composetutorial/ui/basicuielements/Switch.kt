package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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

// Basic Switch
@Preview(showBackground = true)
@Composable
fun BasicSwitch() {
    var checked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Toggle Switch")
            Spacer(modifier = Modifier.width(16.dp))
            Switch(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = if (checked) "ON" else "OFF")
    }
}

// Switch with thumb icon
@Preview(showBackground = true)
@Composable
fun SwitchWithIcon() {
    var checked by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Notifications")
        Spacer(modifier = Modifier.width(16.dp))
        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            thumbContent = {
                Icon(
                    imageVector = if (checked) Icons.Default.Check else Icons.Default.Close,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            }
        )
    }
}

// Switch with custom colors
@Preview(showBackground = true)
@Composable
fun CustomColorSwitch() {
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Custom Switch")
        Spacer(modifier = Modifier.width(16.dp))
        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.onError,
                checkedTrackColor = MaterialTheme.colorScheme.error,
                uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )
    }
}

// Multiple Switches settings screen
@Preview(showBackground = true)
@Composable
fun SwitchSettingsScreen() {
    var wifiEnabled by remember { mutableStateOf(true) }
    var bluetoothEnabled by remember { mutableStateOf(false) }
    var darkModeEnabled by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Wi-Fi", modifier = Modifier.weight(1f))
            Switch(checked = wifiEnabled, onCheckedChange = { wifiEnabled = it })
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Bluetooth", modifier = Modifier.weight(1f))
            Switch(checked = bluetoothEnabled, onCheckedChange = { bluetoothEnabled = it })
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Dark Mode", modifier = Modifier.weight(1f))
            Switch(checked = darkModeEnabled, onCheckedChange = { darkModeEnabled = it })
        }
    }
}
