package com.sample.composetutorial.ui.toolbar

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalToolBar() {
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(title = {
        Text(text = "Toolbar")
    }, navigationIcon = {
        IconButton(onClick = {
            Toast.makeText(contextForToast, "Navigation Icon Click", Toast.LENGTH_SHORT).show()
        }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Navigation icon")
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CentralizedToolBar() {
    val contextForToast = LocalContext.current.applicationContext

    CenterAlignedTopAppBar(title = {
        Text(text = "Compose Tutorial")
    }, navigationIcon = {
        IconButton(onClick = {
            Toast.makeText(contextForToast, "Navigation Icon Click", Toast.LENGTH_SHORT).show()
        }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Navigation icon")
        }
    })
}
