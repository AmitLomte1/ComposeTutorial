package com.sample.composetutorial.scaffold

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.composetutorial.R

@Composable
fun BasicComposeLayout() {

}

@Preview(showBackground = true)
@Composable
fun SearchBarScreen(
    modifier: Modifier = Modifier
) {
    TextField(value = "Search", onValueChange = {}, leadingIcon = {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Icon",
            tint = Color.Black
        )
    }, colors = TextFieldDefaults.textFieldColors(
        unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
        focusedIndicatorColor = MaterialTheme.colorScheme.surface
    ), placeholder = {
        Text(text = "Search here")
    }, modifier = modifier
        .fillMaxWidth()
        .heightIn(56.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_google_icon),
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentDescription = null
        )
        Text(text = "Call now", modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun FavouriteCollectionCard(modifier: Modifier = Modifier) {
    Surface(shape = MaterialTheme.shapes.medium) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.width(255.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_google_icon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(text = "Nature Medium")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData.size) { item ->
//            AlignYourBodyElement(item.component1(), item.component2())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(favoriteCollectionsData.size) { item ->
//            FavoriteCollectionCard(item.drawable, item.text, Modifier.height(80.dp))
        }
    }
}

@Composable
fun HomeSection(
    title: String = "Hello", modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBarScreen(modifier = Modifier.padding(horizontal = 16.dp))
        HomeSection(title = "Main Screen") {
            AlignYourBodyRow()
        }
        HomeSection("Sub Screen") {
            FavouriteCollectionCard()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceVariant, modifier = modifier) {
        NavigationBarItem(selected = true, onClick = {}, icon = {
            Icon(
                imageVector = Icons.Default.Spa, contentDescription = "Spa Icon"
            )
        }, label = {
            Text(text = "Spa Icon")
        })

        NavigationBarItem(selected = true, onClick = {}, icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle, contentDescription = "Profile Icon"
            )
        }, label = {
            Text(text = "Profile Icon")
        })
    }
}

@Composable
fun SootheNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(selected = true, onClick = {}, icon = {
                Icon(
                    imageVector = Icons.Default.Spa, contentDescription = null
                )
            })
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(selected = true, onClick = {}, icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle, contentDescription = null
                )
            })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(bottomBar = { SootheBottomNavigation() }) { values ->
        HomeScreen(modifier = Modifier.padding(values))
    }
}

@Composable
fun MySootheApp(windowSizeClass: WindowSizeClass) {
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
//            MySootheAppPortrait()
        }

        WindowWidthSizeClass.Expanded -> {
//            MySootheAppLandscape()
        }
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ic_google_icon to "Google",
    R.drawable.ic_launcher_foreground to "Foreground",
    R.drawable.ic_launcher_background to "Background",
    R.drawable.ic_google_icon to "Google",
    R.drawable.ic_launcher_foreground to "Foreground",
    R.drawable.ic_launcher_background to "Background"
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.ic_google_icon to "Google",
    R.drawable.ic_launcher_foreground to "Foreground",
    R.drawable.ic_google_icon to "Google",
    R.drawable.ic_launcher_foreground to "Foreground",
    R.drawable.ic_launcher_background to "Background",
    R.drawable.ic_launcher_background to "Background"
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int, val text: String
)

@Composable
fun SideScreen() {
    SideEffect {

    }
}