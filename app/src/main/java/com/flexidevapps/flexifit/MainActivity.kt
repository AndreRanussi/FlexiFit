package com.flexidevapps.flexifit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexidevapps.flexifit.core.navigation.Route
import com.flexidevapps.flexifit.core.navigation.navigate
import com.flexidevapps.flexifit.onboarding.presentation.dob.DobScreen
import com.flexidevapps.flexifit.onboarding.presentation.gender.GenderScreen
import com.flexidevapps.flexifit.onboarding.presentation.welcome.WelcomeScreen
import com.flexidevapps.flexifit.ui.theme.FlexFitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlexFitTheme {
                val navController = rememberNavController()
                var scaffoldState = rememberScaffoldState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ){
                    NavHost(
                        navController = navController,
                        startDestination = Route.WELCOME,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.DOB) {
                            DobScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate,
                                )
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

                    }

                }
            }
        }
    }
}