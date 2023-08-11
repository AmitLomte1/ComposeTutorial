package com.sample.composetutorial.ui.basicuielements

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Scaffold
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerScreen() {

    val images = remember {
        mutableStateListOf(
            "https://picsum.photos/id/237/200/300",
            "https://picsum.photos/seed/picsum/200/300",
            "https://picsum.photos/200/300?grayscale",
            "https://picsum.photos/200/300/?blur",
            "https://picsum.photos/id/870/200/300?grayscale&blur=2"
        )
    }

    val pagerState = rememberPagerState(pageCount = { images.size })
    val matrix = remember {
        ColorMatrix()
    }
    Scaffold(modifier = Modifier.padding(vertical = 8.dp)) {
        HorizontalPager(state = pagerState) {
            val pageOffset = (pagerState.currentPage - it) + pagerState.currentPageOffsetFraction
            val imageSize by animateFloatAsState(
                targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
                animationSpec = tween(durationMillis = 300)
            )

            LaunchedEffect(key1 = imageSize) {
                if (pageOffset != 0.0f) {
                    matrix.setToSaturation(0f)
                } else {
                    matrix.setToSaturation(1f)
                }
            }
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer {
                        scaleX = imageSize
                        scaleY = imageSize
                    },
                model = ImageRequest.Builder(LocalContext.current).data(images[it]).build(),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(matrix)
            )
        }
    }
}