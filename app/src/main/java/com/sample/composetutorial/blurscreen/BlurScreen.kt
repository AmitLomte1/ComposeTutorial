package com.sample.composetutorial.blurscreen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp

@Composable
fun BlurScreen() {

    var isChecked by remember { mutableStateOf(true) }
    val animatedBlur by animateDpAsState(targetValue = if (isChecked) 10.dp else 0.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.blur(
                radius = animatedBlur,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            ),
            text = "Hello World",
            fontSize = MaterialTheme.typography.bodyLarge.fontSize
        )
        Spacer(modifier = Modifier.height(24.dp))
        Switch(checked = isChecked, onCheckedChange = { isChecked = !isChecked })
    }
}