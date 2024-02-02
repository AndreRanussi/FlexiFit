package com.flexidevapps.flexifit.onboarding.presentation.dob

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flexidevapps.flexifit.R
import com.flexidevapps.flexifit.core.domain.preferences.Preferences
import com.flexidevapps.flexifit.core.domain.usecases.DateValidation
import com.flexidevapps.flexifit.core.domain.usecases.FilterOutDigits
import com.flexidevapps.flexifit.core.navigation.Route
import com.flexidevapps.flexifit.core.util.UiEvent
import com.flexidevapps.flexifit.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class DobViewModel @Inject constructor(
    private val preferences: Preferences,
    private val dateValidation: DateValidation,
    private val filterOutDigits: FilterOutDigits
): ViewModel() {


    var selectedDobDay by mutableStateOf("01")
    var selectedDobMonth by mutableStateOf("01")
    var selectedDobYear by mutableStateOf("2000")

    private var unixDob by mutableLongStateOf(0)

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateToUnixConverter(date: String): Long {
        val formatPattern = "dd/MM/yyyy"
        val formatter = DateTimeFormatter.ofPattern(formatPattern)
        val formattedDate = LocalDate.parse(date, formatter)
        return formattedDate.atStartOfDay().toEpochSecond(java.time.ZoneOffset.UTC)
    }

    fun onDobDayEnter(
        dobDay: String,
    ) {
        if(dobDay.length <= 2) {
            this.selectedDobDay = filterOutDigits(dobDay)
        }
    }

    fun onDobMonthEnter(
        dobMonth: String,
    ) {
        if(dobMonth.length <= 2) {
            this.selectedDobMonth = filterOutDigits(dobMonth)
        }
    }

    fun onDobYearEnter(
        dobYear: String,
    ) {
        if(dobYear.length <= 4) {
            this.selectedDobYear = filterOutDigits(dobYear)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onNextClick() {
        viewModelScope.launch {
            val isDateValid = dateValidation(selectedDobDay.toInt(), selectedDobMonth.toInt(), selectedDobYear.toInt())
            val dateString = "$selectedDobDay/$selectedDobMonth/$selectedDobYear"
            if (isDateValid) {
                val unixDate = dateToUnixConverter(dateString)
                preferences.saveDob(unixDate)
                _uiEvent.send(UiEvent.Navigate(Route.HEIGHT))
                println("$unixDate")
            } else {
                _uiEvent.send(
                    UiEvent.ShowSnackBar(
                        UiText.StringResources(R.string.dob_error_message)
                    )
                )
            }
        }
    }
}
