package com.tsungmn.handadeul.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import handadeulbible.composeapp.generated.resources.Res
import handadeulbible.composeapp.generated.resources.pretendard_regular
import org.jetbrains.compose.resources.Font

val Typography
    @Composable
    get() = Typography().let {
        val font = FontFamily(Font(Res.font.pretendard_regular))
        it.copy(
            // On header
            headlineLarge = it.headlineLarge.copy(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            headlineMedium = it.headlineMedium.copy(
                fontFamily = font,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            ),
            headlineSmall = it.headlineSmall.copy(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            // On direct body or card
            titleLarge = it.titleLarge.copy(
                fontFamily = font,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            ),
            titleMedium = it.titleMedium.copy(
                fontFamily = font,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            ),
            titleSmall = it.titleSmall.copy(fontFamily = font), // No usage
            // On direct body or any components
            // FontWeight determined by themselves
            bodyLarge = it.bodyLarge.copy(
                fontFamily = font,
                fontSize = 20.sp,
                lineHeight = 24.sp,
            ),
            bodyMedium = it.bodyMedium.copy(
                fontFamily = font,
                fontSize = 16.sp,
                lineHeight = 24.sp,
            ),
            bodySmall = it.bodySmall.copy(
                fontFamily = font,
                fontSize = 14.sp,
                lineHeight = 24.sp,
            ),
            // No usage
            displayLarge = it.displayLarge.copy(fontFamily = font),
            displayMedium = it.displayMedium.copy(fontFamily = font),
            displaySmall = it.displaySmall.copy(fontFamily = font),
            labelLarge = it.labelLarge.copy(fontFamily = font),
            labelMedium = it.labelMedium.copy(fontFamily = font),
            labelSmall = it.labelSmall.copy(fontFamily = font),
        )
    }