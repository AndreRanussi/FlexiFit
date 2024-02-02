package com.flexidevapps.flexifit.onboarding.presentation.dob

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.flexidevapps.flexifit.R
import com.flexidevapps.flexifit.core.domain.model.Gender
import com.flexidevapps.flexifit.core.presentation.LocalSpacing
import com.flexidevapps.flexifit.core.util.UiEvent
import com.flexidevapps.flexifit.onboarding.presentation.components.ActionButton
import com.flexidevapps.flexifit.onboarding.presentation.components.SelectableButton
import com.flexidevapps.flexifit.onboarding.presentation.components.UnitText
import com.flexidevapps.flexifit.onboarding.presentation.components.UnitTextField

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DobScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: DobViewModel = hiltViewModel(),
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_date_of_birth),
                style = MaterialTheme.typography.h3
            )

            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            Row {

                UnitTextField(
                    value = viewModel.selectedDobDay,
                    onValueChange = viewModel::onDobDayEnter,
                    unit = ""
                )

                UnitText(value = "/")

                UnitTextField(
                    value = viewModel.selectedDobMonth,
                    onValueChange = viewModel::onDobMonthEnter,
                    unit = ""
                )

                UnitText(value = "/")

                UnitTextField(
                    value = viewModel.selectedDobYear,
                    onValueChange = viewModel::onDobYearEnter,
                    unit = ""
                )
            }

            }


        ActionButton(
            text = stringResource(id = R.string.next) ,
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }




}