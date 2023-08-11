package com.sample.composetutorial.navigation.model

const val ARGUMENT_ID_KEY = "id"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen/{$ARGUMENT_ID_KEY}") {
        fun passId(id: Int): String {
            return this.route.replace(oldValue = "{$ARGUMENT_ID_KEY}", newValue = id.toString())
        }
    }
}
