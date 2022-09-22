package com.chungnh.learningcompose

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chungnh.learningcompose.ui.theme.LearningComposeTheme
import com.chungnh.learningcompose.ui.theme.ThemeState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxHeight(),
                ) {
                    Greeting("Android")
                    ChangeThemeButton()
                }
            }
        }
        Log.e(MainActivity::class.java.name, "Create")
    }
}

@Composable
fun ChangeThemeButton() {
    val systemInDarkTheme = isSystemInDarkTheme()
    Button(
        onClick = { ThemeState.switchTheme(systemInDarkTheme) },
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        Text(
            text = "Theme Toggle Button",
            color = MaterialTheme.colors.primaryVariant
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        color = MaterialTheme.colors.primary
    )
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    LearningComposeTheme {
        Greeting("Android")
        ChangeThemeButton()
    }
}