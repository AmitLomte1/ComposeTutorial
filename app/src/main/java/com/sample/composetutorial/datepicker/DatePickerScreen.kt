package com.sample.composetutorial.datepicker

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar
import java.util.Date

@Composable
fun DatePickerScreen() {
    val context = LocalContext.current

    val year: Int
    val month: Int
    val day: Int

    val calenderInstance = Calendar.getInstance()

    year = calenderInstance.get(Calendar.YEAR)
    month = calenderInstance.get(Calendar.MONTH)
    day = calenderInstance.get(Calendar.DAY_OF_MONTH)

    calenderInstance.time = Date()

    val date = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/${month + 1}/$year"
        }, year, month, day
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { datePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        ) {
            Text(text = "Open Calender")
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Selected Date: ${date.value}", fontSize = 30.sp, textAlign = TextAlign.Center)

    }
}