package com.flexidevapps.flexifit.core.navigation

import androidx.navigation.NavController
import com.flexidevapps.flexifit.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}