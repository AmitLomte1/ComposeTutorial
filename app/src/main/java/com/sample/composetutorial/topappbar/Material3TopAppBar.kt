package com.sample.composetutorial.topappbar

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3TopAppBar() {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Menu, contentDescription = "Menu Icon"
                        )
                    }
                },
                title = {
                    Text(text = "Title", color = Color.Black)
                },
//                colors = TopAppBarDefaults.smallTopAppBarColors(
//                containerColor = MaterialTheme.colorScheme.error
//            )
            )
        }, content = {
            CustomList(paddingValues = it)
        })
}

@Composable
fun CustomList(paddingValues: PaddingValues) {
    val numbers = remember {
        mutableStateListOf(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17,
            18,
            19,
            20,
            31,
            32,
            33,
            34,
            35,
            36,
            37,
            38,
            39,
            40
        )
    }

    LazyColumn(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
        items(items = numbers, key = { it.hashCode() }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 24.dp),
                text = "$it",
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Medium
                )


            )
        }
    }
}