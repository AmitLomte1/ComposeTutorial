package com.sample.composetutorial.circularshapeimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.composetutorial.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CircularShapeImage() {
    Image(
        modifier = Modifier
            .size(300.dp)
            .clip(CircleShape)
//            .clip(RoundedCornerShape(size = 50.dp))
            .border(
                width = 10.dp,
                color = Color.Red,
                shape = CircleShape
            ),
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = ""
    )
}