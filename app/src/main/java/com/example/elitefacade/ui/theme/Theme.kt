package com.example.elitefacade.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = ThemeColors.Night.primary,
    surface = ThemeColors.Night.surface,
    background = ThemeColors.Night.background,
    onPrimary = ThemeColors.Night.text,
    onSecondary = ThemeColors.Night.textTitle,
    onBackground = ThemeColors.Night.gradient1,
    onSurface = ThemeColors.Night.gradient0
)

private val LightColorScheme = lightColorScheme(
    primary = ThemeColors.Day.primary,
    surface = ThemeColors.Day.surface,
    background = ThemeColors.Day.background,
    onPrimary = ThemeColors.Day.text,
    onSecondary = ThemeColors.Day.textTitle,
    onBackground = ThemeColors.Day.gradient1,
    onSurface = ThemeColors.Day.gradient0


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun EliteFacadeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    } /*
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
           val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }*/

    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}