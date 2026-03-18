package com.sample.composetutorial.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen() {
    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier.background(Color.Gray), title = {
                Text(text = "Compose App")
            }, navigationIcon = {
                Icon(
                    imageVector = Icons.Filled.Menu, contentDescription = "Menu"
                )
            })
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.background(Color.Black)) {

            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.HeartBroken, contentDescription = "Heart")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        TextScreen()
    }
}

@Composable
fun TextScreen() {
    Text(
        modifier = Modifier.clickable { },
        text = "Hello Android",
        fontSize = 25.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive
    )
}

@Composable
fun LazyRowScreen() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(20) {
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .height(100.dp)
                    .background(Color.Blue)
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .width(5.dp)
            )
        }
    }
}

@Composable
fun LazyColumnScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(20) {
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .height(100.dp)
                    .background(Color.Blue)
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .width(5.dp)
            )
        }
    }
}

@Composable
fun BoxScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .horizontalScroll(scrollState),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        for (i in 1..7) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.Black)
            )
            Spacer(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.Red)
            )
        }
    }
}