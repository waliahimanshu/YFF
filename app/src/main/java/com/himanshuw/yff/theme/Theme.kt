package com.himanshuw.yff.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorPalette = lightColors(
        primary = yellow800,
        primaryVariant = yellow800,
        secondary = yellow800,
        onPrimary = Color.Black,
        onSecondary = Color.Black,
        error = red300,
        onError = Color.Black
)

val LightColorPalette = lightColors(
        primary = yellow,
        primaryVariant = purple700,
        secondary = teal200)


@Composable
fun YFFTheme(isDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val color = if (isDarkTheme) DarkColorPalette else LightColorPalette
    MaterialTheme(
            colors = color,
            typography = typography,
            shapes = shapes,
            content = content
    )
}
