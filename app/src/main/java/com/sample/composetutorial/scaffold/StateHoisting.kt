package com.sample.composetutorial.scaffold

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StateHoisting(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    var darkTheme: Boolean = isSystemInDarkTheme()
    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnBoardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            LazyGreeting()
        }
    }
}

@Composable
fun GreetingsScreen(
    modifier: Modifier = Modifier, names: List<String> = listOf<String>("Amit", "Kumar")
) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name)
        }
    }
}

@Composable
fun LazyGreeting(
    modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = rememberSaveable {
        mutableStateOf(
            false
        )
    }
    val extraPadding by animateDpAsState(
        if (expanded.value) 48.dp else 0.dp, animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        ), label = ""
    )

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = "Hello", color = Color.White)
                Text(
                    text = name,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (expanded.value) {
                    Text(text = ("This is sample expanded text").repeat(14), color = Color.White)
                }
            }
            IconButton(onClick = { expanded.value = !expanded.value }) {
                Icon(
                    imageVector = if (expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded.value) "Show Less" else "Show More",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Basic Code lab")
        Button(modifier = Modifier.padding(vertical = 20.dp), onClick = onContinueClicked) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "Dark")
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(onContinueClicked = { /*TODO*/ })
}

@Preview(showBackground = true)
@Composable
fun GreetingsPreview() {
    GreetingsScreen()

}





