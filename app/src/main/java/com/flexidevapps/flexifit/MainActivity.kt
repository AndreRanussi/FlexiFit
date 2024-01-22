package com.flexidevapps.flexifit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexidevapps.flexifit.core.navigation.Route
import com.flexidevapps.flexifit.core.navigation.navigate
import com.flexidevapps.flexifit.onboarding.onboarding_presentation.welcome.WelcomeScreen
import com.flexidevapps.flexifit.ui.theme.FlexFitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlexFitTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ) {
                    composable(Route.WELCOME) {
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.DOB) {

                    }
                    composable(Route.GENDER) {

                    }
                    composable(Route.HEIGHT) {

                    }
                    composable(Route.WEIGHT) {

                    }
                    composable(Route.ACTIVITY) {

                    }
                    composable(Route.GOAL) {

                    }
                    composable(Route.NUTRIENT_GOAL) {

                    }
                    composable(Route.TRACKER_OVERVIEW) {

                    }
                    composable(Route.FOOD_SEARCH) {

                    }

                    composable(Route.PROFILE_OVERVIEW) {

                    }

                    composable(Route.INGREDIENTS_RECIPES) {

                    }

                    composable(Route.TRACKER_OVERVIEW) {

                    }

                    composable(Route.TRAINING_OVERVIEW) {

                    }

                    composable(Route.CALENDAR_OVERVIEW) {

                    }





                }
            }
        }
    }
}