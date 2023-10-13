package com.example.test_pt_serasi_autoraya.core.values

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val colorPallete = lightColors(
    primary = AppColors.Apricot,
    primaryVariant = AppColors.Apricot_400,

)

@Composable
fun DefaultAppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = colorPallete,
        content = content
    )
}