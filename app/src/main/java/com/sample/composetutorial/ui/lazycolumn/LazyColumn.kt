package com.sample.composetutorial.ui.lazycolumn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.sample.composetutorial.repository.PersonRepository

@Composable
fun LazyColumnScreen() {
    val repository = PersonRepository()
    val getAllData = repository.getAllData()

    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
//        items(getAllData.size) {
//            CustomItem(person = getAllData[it])
//        }
        itemsIndexed(getAllData) { index, item ->
            CustomItem(person = item)
        }
    }
}