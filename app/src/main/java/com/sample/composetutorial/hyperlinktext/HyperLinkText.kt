package com.sample.composetutorial.hyperlinktext

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HyperlinkText(
    modifier: Modifier = Modifier,
    fullText: String,
    hyperLinks: Map<String, String>,
    textStyle: TextStyle = TextStyle.Default,
    linkTextColor: Color = Color.Blue,
    linkTextFontWeight: FontWeight = FontWeight.Normal,
    linkTextDecoration: TextDecoration = TextDecoration.None,
    FontSize: TextUnit = TextUnit.Unspecified
) {
    val annotatedString = buildAnnotatedString {
        append(fullText)

        for ((key, value) in hyperLinks) {

            val startIndex = fullText.indexOf(key)
            val endIndex = startIndex + key.length
            addStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    fontSize = FontSize,
                    fontWeight = linkTextFontWeight,
                    textDecoration = linkTextDecoration
                ), start = startIndex, end = endIndex
            )
            addStringAnnotation(
                tag = "URL", annotation = value, start = startIndex, end = endIndex
            )
        }
        addStyle(
            style = SpanStyle(
                fontSize = FontSize
            ), start = 0, end = fullText.length
        )
    }

    val uriHandler = LocalContext.current

    ClickableText(modifier = modifier, text = annotatedString, style = textStyle, onClick = {
        annotatedString.getStringAnnotations("URL", it, it).firstOrNull()?.let { stringAnnotation ->

            openUriIntent(stringAnnotation.item, uriHandler)
        }
    })
}


fun openUriIntent(item: String, context: Context) {
    val shareIntent = Intent(Intent.ACTION_SEND)
    shareIntent.type = "text/plain"
    shareIntent.putExtra(Intent.EXTRA_TEXT, item)
    context.startActivity(Intent.createChooser(shareIntent, "Share link using"))
}

@Composable
fun HyperTextLinkPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HyperlinkText(
            fullText = "By using our services are agreeing to our\n" + "Terms and Privacy statement",
            hyperLinks = mutableMapOf(
                "Terms" to "https://google.com", "Privacy statement" to "https://google.com"
            ),
            textStyle = TextStyle(
                textAlign = TextAlign.Center, color = Color.Gray
            ),
            linkTextColor = Color.Green,
            FontSize = 18.sp
        )
    }
}