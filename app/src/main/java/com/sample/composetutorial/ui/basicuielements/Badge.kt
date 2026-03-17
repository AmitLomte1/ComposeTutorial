package com.sample.composetutorial.ui.basicuielements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Badge with Icon
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BadgeWithIcon() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Badge with count
        BadgedBox(
            badge = {
                Badge { Text(text = "5") }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications"
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Badge without count (dot badge)
        BadgedBox(
            badge = { Badge() }
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorites"
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Badge with large count
        BadgedBox(
            badge = {
                Badge { Text(text = "99+") }
            }
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart"
            )
        }
    }
}

// Badge in NavigationBar
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BadgeInNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                BadgedBox(badge = { Badge { Text("3") } }) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                }
            },
            label = { Text("Notifications") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                BadgedBox(badge = { Badge() }) {
                    Icon(Icons.Default.Favorite, contentDescription = "Favorites")
                }
            },
            label = { Text("Favorites") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
            },
            label = { Text("Cart") }
        )
    }
}
