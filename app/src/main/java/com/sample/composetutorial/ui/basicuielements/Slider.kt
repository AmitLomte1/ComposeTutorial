package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Basic Slider
@Preview(showBackground = true)
@Composable
fun BasicSlider() {
    var sliderValue by remember { mutableFloatStateOf(0f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Value: ${sliderValue.toInt()}")
        Spacer(modifier = Modifier.height(8.dp))
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f
        )
    }
}

// Slider with steps
@Preview(showBackground = true)
@Composable
fun SteppedSlider() {
    var sliderValue by remember { mutableFloatStateOf(0f) }
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Volume: ${sliderValue.toInt()}%")
        Spacer(modifier = Modifier.height(8.dp))
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f,
            steps = 9
        )
    }
}

// Custom Color Slider
@Preview(showBackground = true)
@Composable
fun CustomColorSlider() {
    var sliderValue by remember { mutableFloatStateOf(50f) }
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Brightness: ${sliderValue.toInt()}%")
        Spacer(modifier = Modifier.height(8.dp))
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.error,
                activeTrackColor = MaterialTheme.colorScheme.error,
                inactiveTrackColor = MaterialTheme.colorScheme.errorContainer
            )
        )
    }
}

// Range Slider
@Preview(showBackground = true)
@Composable
fun RangeSliderDemo() {
    var sliderValues by remember { mutableStateOf(20f..80f) }
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Price Range: $${sliderValues.start.toInt()} - $${sliderValues.endInclusive.toInt()}")
        Spacer(modifier = Modifier.height(8.dp))
        RangeSlider(
            value = sliderValues,
            onValueChange = { sliderValues = it },
            valueRange = 0f..200f
        )
    }
}
