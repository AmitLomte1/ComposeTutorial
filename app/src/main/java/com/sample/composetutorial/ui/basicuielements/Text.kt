package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sample.composetutorial.R

// normal text
@Composable
fun CustomText() {
    androidx.compose.material3.Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        color = MaterialTheme.colorScheme.error,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Thin
    )
}

// Text with build annotated string
@Composable
fun TextWithSpanStyle() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                withStyle(
                    style = SpanStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                ) {
                    append("A")
                }
                append("M")
                append("I")
                append("T")
            }
        }, modifier = Modifier.width(200.dp))
    }
}

// Text with repeat
@Preview(showBackground = true)
@Composable
fun TextWithRepeat() {
    Text(
        "Hello".repeat(20),
        maxLines = 2,
        fontSize = 25.sp,
        overflow = TextOverflow.Ellipsis
    )
}

// Text with selection to copy
@Composable
fun TextSelection() {
    SelectionContainer() {
        Column {
            Text("Hello World")
            DisableSelection {
                Text("Hello World")
            }
            Text("Hello World")
        }
    }
}

// Text with Subscript and SuperScript
@Composable
fun SubscriptFunction(
    normalText: String,
    superText: String,

    ) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.Normal,
//                baselineShift = BaselineShift.Superscript,
                baselineShift = BaselineShift.Subscript
            )
        ) {
            append(superText)
        }
    })
}