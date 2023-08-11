package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import com.sample.composetutorial.ui.theme.Purple80
import com.sample.composetutorial.ui.theme.PurpleGrey80

@Composable
fun GradientButton() {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Blue
        ),
        onClick = {

        }
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Purple80,
                            PurpleGrey80
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Button", color = Color.Blue)
        }
    }
}