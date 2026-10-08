package com.pionier.languages.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BrainTrainingScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "🧠 Renforcement cérébral",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("🧠 Mémorisation", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("Mémorisez et répétez des mots et des phrases")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Lancer") }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("⚡ Réaction", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("Répondez rapidement aux questions")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Lancer") }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("🔮 Anticipation", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("Anticipez et prédisez le mot suivant")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Lancer") }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("💡 Réflexion", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("Résolvez des énigmes et des problèmes")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Lancer") }
            }
        }
    }
}
