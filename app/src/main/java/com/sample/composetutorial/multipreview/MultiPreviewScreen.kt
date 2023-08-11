package com.sample.composetutorial.multipreview

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@FontScalePreviews
@DevicePreview
@Composable
fun MultiPreviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        MultiScreen()
    }
}

@Composable
fun MultiScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(size = 12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Android",
                color = androidx.compose.material.MaterialTheme.colors.background,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = androidx.compose.material.MaterialTheme.typography.h5.fontSize)
            )
            Text(
                text = "Developer Mode On",
                color = androidx.compose.material.MaterialTheme.colors.background,
                textAlign = TextAlign.Center
            )
        }
    }
}
