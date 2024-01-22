package com.flexidevapps.flexifit.core.domain.model

sealed class GoalType( val name: String) {
    object Cut: GoalType("cut")
    object Maintain: GoalType("maintain")
    object Bulk: GoalType("bulk")


    companion object {
        fun fromString(name: String): GoalType {
            return when(name){
                "cut" -> Cut
                "maintain" -> Maintain
                "bulk" -> Bulk
                else -> Maintain
            }
        }
    }
}