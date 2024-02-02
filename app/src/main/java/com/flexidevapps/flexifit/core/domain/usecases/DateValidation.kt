package com.flexidevapps.flexifit.core.domain.usecases

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class DateValidation {

    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(day: Int, month: Int, year: Int): Boolean {
        return try {
            val dateString = "$day/$month/$year"
            val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")
            val parsedDate = LocalDate.parse(dateString, formatter)
            true
        } catch (e: DateTimeParseException) {
            println(e.message)
            false
        }
    }
}