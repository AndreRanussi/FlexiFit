package com.flexidevapps.flexifit.core.domain.usecases

class FilterOutDigits {

    operator fun invoke(text: String): String {
        return text.filter { it.isDigit()}
    }
}