package com.sample.composetutorial.webview

import android.graphics.Bitmap
import android.webkit.WebView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.LoadingState
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewNavigator
import com.google.accompanist.web.rememberWebViewState

@Preview(showBackground = true)
@Composable
fun WebScreen() {
    var url by remember { mutableStateOf("https://google.com") }
    val state = rememberWebViewState(url = url)
    val navigator = rememberWebViewNavigator()
    var textFieldValue by remember(state.lastLoadedUrl) {
        mutableStateOf(state.lastLoadedUrl ?: "")
    }

    Column {
        TopAppBar() {
            IconButton(onClick = { navigator.navigateBack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            IconButton(onClick = { navigator.navigateForward() }) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Forward"
                )
            }
            Text(
                text = "Web Browser", style = TextStyle(
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = MaterialTheme.typography.h6.fontWeight
                )
            )
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { navigator.reload() }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh"
                    )
                }
                IconButton(onClick = { url = textFieldValue }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Go"
                    )
                }
            }
        }

        Row(modifier = Modifier.padding(all = 12.dp)) {
            BasicTextField(
                modifier = Modifier.weight(9f),
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                maxLines = 1
            )
            if (state.errorsForCurrentRequest.isNotEmpty()) {
                Icon(
                    modifier = Modifier
                        .weight(1f),
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Error",
                    tint = Color.Red
                )
            }
        }
        val loadingState = state.loadingState
        if (loadingState is LoadingState.Loading) {
            LinearProgressIndicator(
                progress = loadingState.progress,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // A custom WebViewClient and WebChromeClient can be provided via subclassing
        val webClient = remember {
            object : AccompanistWebViewClient() {
                override fun onPageStarted(
                    view: WebView,
                    url: String?,
                    favicon: Bitmap?
                ) {
                    super.onPageStarted(view, url, favicon)
                }
            }
        }

        WebView(
            state = state,
            modifier = Modifier.weight(1f),
            navigator = navigator,
            onCreated = { webView ->
                webView.settings.javaScriptEnabled = true
            },
            client = webClient
        )
    }
}