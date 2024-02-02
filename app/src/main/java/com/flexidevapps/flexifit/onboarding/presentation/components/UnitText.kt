package com.flexidevapps.flexifit.onboarding.presentation.components


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.flexidevapps.flexifit.core.presentation.LocalSpacing


@Composable
fun UnitText(
     value: String,
     textStyle: TextStyle = TextStyle(
         color = MaterialTheme.colors.primaryVariant,
         fontSize = 50.sp
     ),
) {
    val spacing = LocalSpacing.current
    Text(
        text = value,
        style = textStyle
    )

}