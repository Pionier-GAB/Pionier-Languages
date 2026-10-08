package com.pionier.languages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pionier.languages.screens.BrainTrainingScreen
import com.pionier.languages.screens.DictionaryScreen
import com.pionier.languages.screens.HomeScreen
import com.pionier.languages.screens.LanguageSelectionScreen
import com.pionier.languages.screens.ProfileDiplomaScreen
import com.pionier.languages.screens.SettingsScreen
import com.pionier.languages.ui.theme.AppTheme

enum class AppScreen {
    HOME, LANGUAGES, DICTIONARY, BRAIN_TRAINING, PROFILE
}

@Composable
fun App() {
    AppTheme(darkTheme = true) {
        val currentScreen = remember { mutableStateOf(AppScreen.HOME) }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = currentScreen.value == AppScreen.HOME,
                        onClick = { currentScreen.value = AppScreen.HOME },
                        icon = { Icon(Icons.Filled.Home, "Home") },
                        label = { Text("Accueil") }
                    )
                    NavigationBarItem(
                        selected = currentScreen.value == AppScreen.LANGUAGES,
                        onClick = { currentScreen.value = AppScreen.LANGUAGES },
                        icon = { Icon(Icons.Filled.Menu, "Languages") },
                        label = { Text("Langues") }
                    )
                    NavigationBarItem(
                        selected = currentScreen.value == AppScreen.DICTIONARY,
                        onClick = { currentScreen.value = AppScreen.DICTIONARY },
                        icon = { Icon(Icons.Filled.Menu, "Dictionary") },
                        label = { Text("Dict") }
                    )
                    NavigationBarItem(
                        selected = currentScreen.value == AppScreen.BRAIN_TRAINING,
                        onClick = { currentScreen.value = AppScreen.BRAIN_TRAINING },
                        icon = { Icon(Icons.Filled.Menu, "Brain") },
                        label = { Text("Cérébral") }
                    )
                    NavigationBarItem(
                        selected = currentScreen.value == AppScreen.PROFILE,
                        onClick = { currentScreen.value = AppScreen.PROFILE },
                        icon = { Icon(Icons.Filled.Settings, "Profile") },
                        label = { Text("Profil") }
                    )
                }
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                when (currentScreen.value) {
                    AppScreen.HOME -> HomeScreen()
                    AppScreen.LANGUAGES -> LanguageSelectionScreen()
                    AppScreen.DICTIONARY -> DictionaryScreen()
                    AppScreen.BRAIN_TRAINING -> BrainTrainingScreen()
                    AppScreen.PROFILE -> ProfileDiplomaScreen()
                }
            }
        }
    }
}
