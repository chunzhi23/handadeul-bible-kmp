package com.tsungmn.handadeul.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun HandadeulTheme(
    colorScheme: ColorScheme = MaterialTheme.colorScheme,
    content: @Composable () -> Unit
) {
    isSystemInDarkTheme()
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography
    ) {
        content()
    }
}