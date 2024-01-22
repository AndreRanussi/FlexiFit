package com.flexidevapps.flexifit.core.domain.model

sealed class ActivityLevel(val name: String) {
    object Sedentary: ActivityLevel("sedentary")
    object LightlyActive : ActivityLevel("lightly_active ")
    object ModeratelyActive : ActivityLevel("moderately_active ")
    object VeryActive : ActivityLevel("very_active ")
    object ExtremelyActive : ActivityLevel("extremely_active ")

    // Sedentary (Little Exercise + Work a Desk Job) - 1.2
    // Lightly Active (Light Exercise 1-3 Days/week) - 1.375
    // Moderately Active (Moderate Exercise 3-5 days/week) - 1.55
    // Very Active (Heavy Exercise 6-7 Days/Week) - 1.725
    // Extremely Active (Very Heavy Exercise) - 1.9

    companion object {
        fun fromString(name: String): ActivityLevel {
            return when(name){
                "sedentary" -> Sedentary
                "lightly_active" -> LightlyActive
                "moderately_active" -> ModeratelyActive
                "very_active" -> VeryActive
                "extremely_active" -> ExtremelyActive
                else -> LightlyActive
            }
        }
    }
}