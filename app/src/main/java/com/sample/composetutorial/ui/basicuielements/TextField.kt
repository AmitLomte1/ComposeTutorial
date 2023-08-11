package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleText() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }
        val maxChar = 8
        TextField(
            value = text,
            placeholder = { Text(text = "Type here") },
            onValueChange = { enteredValue ->
                // to set limit of char
                if (enteredValue.length <= maxChar) text = enteredValue
            },
//            enabled = false,
//            readOnly = true,
            label = {
                Text(text = "User Name")
            },
//            singleLine = true
//        maxLines = 2,
//        isError = true
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlineText() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }
        val maxChar = 8
        OutlinedTextField(
            value = text,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colorScheme.error
            ),
            placeholder = { Text(text = "Type here") },
            onValueChange = { enteredValue ->
                // to set limit of char
                if (enteredValue.length <= maxChar) text = enteredValue
            },
//            enabled = false,
//            readOnly = true,
            label = {
                Text(text = "User Name")
            },
//            singleLine = true
//        maxLines = 2,
//        isError = true
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            )
        )
    }
}