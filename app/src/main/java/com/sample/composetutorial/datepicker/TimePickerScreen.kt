package com.sample.composetutorial.datepicker

import android.app.TimePickerDialog
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
fun TimePickerScreen() {
    val context = LocalContext.current

    val calenderInstance = Calendar.getInstance()

    val hour = calenderInstance.get(Calendar.HOUR_OF_DAY)
    val minute = calenderInstance.get(Calendar.MINUTE)

    calenderInstance.time = Date()

    val time = remember { mutableStateOf("") }

    val timePickerDialog = TimePickerDialog(
        context,
        { _, mHour: Int, mMinute: Int ->
            time.value = "$mHour:$mMinute"
        }, hour, minute, false
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { timePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        ) {
            Text(text = "Open Time Picker")
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Selected Time: ${time.value}", fontSize = 30.sp, textAlign = TextAlign.Center)

    }
}