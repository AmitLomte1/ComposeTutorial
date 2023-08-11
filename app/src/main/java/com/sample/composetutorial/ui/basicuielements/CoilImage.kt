package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.sample.composetutorial.R

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(50.dp), contentAlignment = Alignment.Center
    ) {
        val painter = rememberAsyncImagePainter(
            model = "https://avatars.githubusercontent.com/u/",
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_google_icon),
        )
//        val painterState = painter.state
        Image(painter = painter, contentDescription = "")
//        if (painterState is AsyncImagePainter.State.Loading) {
//            CircularProgressIndicator()
//        }
    }
}