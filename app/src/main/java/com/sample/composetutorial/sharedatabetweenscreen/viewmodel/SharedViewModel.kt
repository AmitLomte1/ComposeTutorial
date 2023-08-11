package com.sample.composetutorial.sharedatabetweenscreen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sample.composetutorial.sharedatabetweenscreen.model.Person

class SharedViewModel : ViewModel() {

    var person by mutableStateOf<Person>(value = Person("", ""))
        private set

    fun addPerson(newPerson: Person) {
        person = newPerson
    }

}