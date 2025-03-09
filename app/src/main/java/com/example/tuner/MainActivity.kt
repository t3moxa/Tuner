package com.example.tuner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppStart()
        }
    }
}

@Serializable
object MainScreen
@Serializable
object TunerScreen
@Serializable
object NoteIdentifierScreen
@Serializable
object MetronomeScreen
@Serializable
object SettingsScreen

@Composable
fun AppStart() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainScreen) {
        composable<MainScreen> { MainScreen(
            onNavigateToTuner = {
                navController.navigate(
                    route = TunerScreen
                )
            },
            onNavigateToMetronome = {
                navController.navigate(
                    route = MetronomeScreen
                )
            },
            onNavigateToSettings = {
                navController.navigate(
                    route = SettingsScreen
                )
            }
        ) }
        composable<TunerScreen> { TunerScreen(
            onNavigateToNoteIdentifier = {
                navController.navigate(
                    route = NoteIdentifierScreen
                )
            },
            onNavigateToMainScreen = {
                navController.navigate(
                    route = MainScreen
                )
            },
            onNavigateToSettings = {
                navController.navigate(
                    route = SettingsScreen
                )
            }
        ) }
        composable<NoteIdentifierScreen> { NoteIdentifierScreen(
            onNavigateToTuner = {
                navController.navigate(
                    route = TunerScreen
                )
            },
            onNavigateToMainScreen = {
                navController.navigate(
                    route = MainScreen
                )
            },
            onNavigateToSettings = {
                navController.navigate(
                    route = SettingsScreen
                )
            }
        ) }
        composable<MetronomeScreen> { MetronomeScreen(
            onNavigateToMainScreen = {
                navController.navigate(
                    route = MainScreen
                )
            },
            onNavigateToSettings = {
                navController.navigate(
                    route = SettingsScreen
                )
            }
        )  }
        composable<SettingsScreen> { SettingsScreen(
            onNavigateToMainScreen = {
                navController.navigate(
                    route = MainScreen
                )
            }

        )  }
    }
}