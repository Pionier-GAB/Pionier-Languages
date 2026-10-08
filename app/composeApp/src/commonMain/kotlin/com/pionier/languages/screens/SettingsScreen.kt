package com.pionier.languages.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    var darkMode by remember { mutableStateOf(true) }
    var soundEnabled by remember { mutableStateOf(true) }
    var offlineMode by remember { mutableStateOf(false) }
    var languageToolEnabled by remember { mutableStateOf(true) }
    var autoSaveEnabled by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "⚙️ Paramètres",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Section Affichage
        Text(
            "Affichage",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Thème sombre")
                    Spacer(modifier = Modifier.width(16.dp))
                    Switch(checked = darkMode, onCheckedChange = { darkMode = it })
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    "Active le thème sombre pour une meilleure expérience nocturne",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Section Audio
        Text(
            "Audio",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Son activé")
                    Spacer(modifier = Modifier.width(16.dp))
                    Switch(checked = soundEnabled, onCheckedChange = { soundEnabled = it })
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    "Active la synthèse vocale pour la prononciation",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Section Réseau
        Text(
            "Réseau",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Mode hors ligne")
                    Spacer(modifier = Modifier.width(16.dp))
                    Switch(checked = offlineMode, onCheckedChange = { offlineMode = it })
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    "Utilise les contenus téléchargés sans connexion",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Section IA
        Text(
            "Intelligence Artificielle",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Correction grammaticale")
                    Spacer(modifier = Modifier.width(16.dp))
                    Switch(checked = languageToolEnabled, onCheckedChange = { languageToolEnabled = it })
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    "Active LanguageTool pour la correction en temps réel",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Section Sauvegarde
        Text(
            "Sauvegarde",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Sauvegarde auto")
                    Spacer(modifier = Modifier.width(16.dp))
                    Switch(checked = autoSaveEnabled, onCheckedChange = { autoSaveEnabled = it })
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    "Sauvegarde automatiquement votre progression",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // À propos
        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("📋 À propos", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Pionier-Languages v1.0.0", style = MaterialTheme.typography.bodySmall)
                Text("© 2026 Pionier-GAB", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Basé sur : CEFR, HSK, Goethe-Institut, ALC, Domaine public",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
