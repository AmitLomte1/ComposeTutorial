package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.composetutorial.R

// Basic Image from drawable resource
@Preview(showBackground = true)
@Composable
fun BasicImage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Icon",
            modifier = Modifier.size(100.dp)
        )
        Text(text = "Basic Image")
    }
}

// Circular Image
@Preview(showBackground = true)
@Composable
fun CircularImage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Circular Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Text(text = "Circular Image")
    }
}

// Rounded Corner Image
@Preview(showBackground = true)
@Composable
fun RoundedCornerImage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Rounded Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(text = "Rounded Corner Image")
    }
}

// Image with different content scales
@Preview(showBackground = true)
@Composable
fun ImageContentScales() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // ContentScale.Fit
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Fit Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(100.dp)
        )
        Text(text = "ContentScale.Fit")

        // ContentScale.FillBounds
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "FillBounds Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(100.dp)
        )
        Text(text = "ContentScale.FillBounds")
    }
}
