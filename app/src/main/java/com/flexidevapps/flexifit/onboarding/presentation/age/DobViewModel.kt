package com.flexidevapps.flexifit.onboarding.presentation.age

import android.app.Application
import android.app.LocaleConfig
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flexidevapps.flexifit.core.domain.preferences.Preferences
import com.flexidevapps.flexifit.core.navigation.Route
import com.flexidevapps.flexifit.core.util.UiEvent
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DobViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {



    private var dob by mutableStateOf<String>("01/01/2000")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onDobEnter(
        dobString: String,
        application: Application
    ) {
        if (dobString.length == 10) {
            dob = dobString
    } else {
        Toast.makeText(application as Context,
            "Please enter you age following the required format e.g. 01/01/2000",
            Toast.LENGTH_LONG
            ).show()

        }

    }

    fun nextClick() {
        viewModelScope.launch {
            preferences.saveDob(dob)
            _uiEvent.send(UiEvent.Navigate(Route.HEIGHT))
        }
    }

}