package com.pionier.languages.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFD740),
    secondary = Color(0xFFFFC107),
    tertiary = Color(0xFFFFA000),
    background = Color(0xFF111111),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color(0xFF111111),
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFFFFFFF)
)

private val LightColors = lightColorScheme(
    primary = Color(0xFFFFD740),
    secondary = Color(0xFFFFC107),
    tertiary = Color(0xFFFFA000),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFF5F5F5),
    onPrimary = Color(0xFF111111),
    onBackground = Color(0xFF111111),
    onSurface = Color(0xFF111111)
)

@Composable
fun AppTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}
