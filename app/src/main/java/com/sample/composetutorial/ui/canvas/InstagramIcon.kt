package com.sample.composetutorial.ui.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun InstagramIcon() {
    val instagramColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            brush = Brush.linearGradient(colors = instagramColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instagramColors),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instagramColors),
            radius = 13f,
            center = Offset(this.size.width * .80f, this.size.height * 0.20f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FacebookIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            color = Color(0xFF1776d1),
            cornerRadius = CornerRadius(20f, 20f)
        )
        drawContext.canvas.nativeCanvas.drawText(
            "f",
            center.x + 25,
            center.y + 90,
            android.graphics.Paint()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GooglePhotoIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawArc(
            color = Color(0xFFf04231),
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            size = androidx.compose.ui.geometry.Size(
                width = size.width * .50f,
                height = size.height * .50f
            ),
            topLeft = Offset(size.width * .25f, 0f)
        )

        drawArc(
            color = Color(0xFF4385f7),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            size = androidx.compose.ui.geometry.Size(
                width = size.width * .50f,
                height = size.height * .50f
            ),
            topLeft = Offset(size.width * .50f, size.height * .25f)
        )

        drawArc(
            color = Color(0xFF30a952),
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            size = androidx.compose.ui.geometry.Size(
                width = size.width * .50f,
                height = size.height * .50f
            ),
            topLeft = Offset(0f, size.height * .25f)
        )

        drawArc(
            color = Color(0xFFffbf00),
            startAngle = 270f,
            sweepAngle = -180f,
            useCenter = true,
            size = androidx.compose.ui.geometry.Size(
                width = size.width * .50f,
                height = size.height * .50f
            ),
            topLeft = Offset(size.width * .25f, size.height * .50f)
        )
    }
}