package com.tsungmn.handadeul.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.tsungmn.handadeul.HandadeulCommon
import com.tsungmn.handadeul.theme.DarkColorScheme
import com.tsungmn.handadeul.theme.HandadeulTheme
import com.tsungmn.handadeul.theme.LightColorScheme

@Composable
fun HandadeulAndroid(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    HandadeulTheme(colorScheme) {
        HandadeulCommon()
    }
}