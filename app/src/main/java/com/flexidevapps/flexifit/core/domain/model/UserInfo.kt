package com.flexidevapps.flexifit.core.domain.model

data class UserInfo(
    val gender: Gender,
    val dob: Long,
    val weight: Float,
    val height: Int,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float
)