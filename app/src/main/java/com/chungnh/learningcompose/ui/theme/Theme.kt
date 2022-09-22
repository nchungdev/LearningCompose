package com.chungnh.learningcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

object ThemeState {
    private var mutableState = mutableStateOf(-1)
    val darkModeState: State<Int>
        get() = mutableState

    fun updateThemeFromDb(theme: Int) {
        mutableState.value = theme
    }

    fun switchTheme(isSystemInDarkTheme: Boolean) {
        val oldTheme = darkModeState.value
        val isDarkTheme = if (oldTheme == -1) isSystemInDarkTheme else oldTheme == 1
        if (isDarkTheme) mutableState.value = 0
        else mutableState.value = 1
    }
}

private val DarkColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.Black,
)

private val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.White,


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun LearningComposeTheme(
    darkTheme: Boolean = if (ThemeState.darkModeState.value == -1) isSystemInDarkTheme() else ThemeState.darkModeState.value == 1,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}