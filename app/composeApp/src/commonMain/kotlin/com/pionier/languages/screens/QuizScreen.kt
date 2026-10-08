package com.pionier.languages.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuizScreen() {
    var currentQuestion by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf("") }
    var quizCompleted by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }

    val totalQuestions = 5

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        if (!quizCompleted) {
            Text(
                "🧪 Quiz",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LinearProgressIndicator(
                progress = { (currentQuestion + 1).toFloat() / totalQuestions },
                modifier = Modifier.fillMaxWidth()
            )
            Text("${currentQuestion + 1} / $totalQuestions", modifier = Modifier.align(Alignment.End).padding(8.dp))

            Spacer(modifier = Modifier.height(16.dp))

            Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Question ${currentQuestion + 1}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Quelle est la bonne réponse ?")

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { selectedAnswer = "A" },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Option A") }
                    Button(
                        onClick = { selectedAnswer = "B" },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Option B") }
                    Button(
                        onClick = { selectedAnswer = "C" },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Option C") }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (currentQuestion > 0) {
                    Button(onClick = { currentQuestion-- }) { Text("Précédent") }
                }

                if (currentQuestion < totalQuestions - 1) {
                    Button(onClick = { currentQuestion++ }) { Text("Suivant") }
                } else {
                    Button(onClick = { quizCompleted = true }) { Text("Valider") }
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    if (score >= 3) "✅ Réussi!" else "❌ Non réussi",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Score: $score / $totalQuestions (${(score * 100) / totalQuestions}%)",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    if (score >= 3) "Cours assimilé ✅" else "Cours non assimilé ❌",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = {}) { Text("Retour") }
            }
        }
    }
}
