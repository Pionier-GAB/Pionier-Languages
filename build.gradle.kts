plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinSerialization) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

tasks.register("generateCourses") {
    doLast {
        println("🚀 Génération des cours Pionier-Languages...")

        val languages = listOf(
            Triple("en", "English", listOf("A1", "A2", "B1", "B2", "C1", "C2")),
            Triple("de", "Deutsch", listOf("A1", "A2", "B1", "B2", "C1", "C2")),
            Triple("fr", "Français", listOf("A1", "A2", "B1", "B2", "C1", "C2")),
            Triple("zh", "中文", listOf("A1", "A2", "B1", "B2", "C1", "C2")),
            Triple("punu", "Punu", listOf("A1", "A2")),
            Triple("fang", "Fang", listOf("A1", "A2")),
            Triple("kota", "Kota", listOf("A1", "A2")),
            Triple("teke", "Téké", listOf("A1", "A2"))
        )

        languages.forEach { (code, label, levels) ->
            println("\n📚 Langue: $label ($code)")
            levels.forEach { level ->
                println("  • Niveau: $level")
                (1..20).forEach { courseNum ->
                    val coursePath = file("content/langues/$code/niveaux/$level/cours/${String.format("%02d", courseNum)}")
                    coursePath.mkdirs()

                    val metadataFile = File(coursePath, "metadata.json")
                    if (!metadataFile.exists()) {
                        val jsonContent = """{
  "id": "$code-${level.lowercase()}-${String.format("%02d", courseNum)}",
  "language": "$code",
  "level": "$level",
  "courseNumber": $courseNum,
  "title": "Cours $label - $level ($courseNum)",
  "description": "Contenu de cours pour $label niveau $level",
  "audioPath": "content/langues/$code/niveaux/$level/cours/${String.format("%02d", courseNum)}/audio.mp3",
  "transcriptPath": "content/langues/$code/niveaux/$level/cours/${String.format("%02d", courseNum)}/transcript.txt",
  "readingPath": "content/langues/$code/niveaux/$level/cours/${String.format("%02d", courseNum)}/reading.txt",
  "speakingPrompt": "Parlez de ce cours",
  "writingPrompt": "Écrivez sur ce sujet",
  "skills": ["listening", "speaking", "reading", "writing"],
  "tags": ["language", "level-$level"],
  "sourceNotes": ["CEFR/HSK/Goethe", "Public Domain", "Open Educational Resources"],
  "cefr": "$level",
  "hskLevel": 0,
  "vocabulary": [
    {"word": "word1", "partOfSpeech": "noun", "definition": "définition", "translation": "traduction", "phonetic": "fəˈnetɪk"}
  ],
  "grammarPoints": [
    {"rule": "Rule 1", "explanation": "Explication", "examples": ["Exemple 1"], "difficulty": "basic"}
  ],
  "quizQuestions": [
    {"id": "q1", "type": "multiple_choice", "question": "Question 1?", "correctAnswer": "Réponse A", "options": ["Réponse A", "Réponse B", "Réponse C"], "explanation": "Explication", "skill": "listening", "audioPath": ""},
    {"id": "q2", "type": "true_false", "question": "Est-ce vrai?", "correctAnswer": "true", "options": [], "explanation": "Explication", "skill": "reading", "audioPath": ""},
    {"id": "q3", "type": "short_answer", "question": "Répondez:", "correctAnswer": "réponse", "options": [], "explanation": "Explication", "skill": "writing", "audioPath": ""},
    {"id": "q4", "type": "multiple_choice", "question": "Question 2?", "correctAnswer": "Option 1", "options": ["Option 1", "Option 2"], "explanation": "Explication", "skill": "listening", "audioPath": ""},
    {"id": "q5", "type": "true_false", "question": "Vrai ou faux?", "correctAnswer": "false", "options": [], "explanation": "Explication", "skill": "reading", "audioPath": ""}
  ]
}""".trimIndent()
                        metadataFile.writeText(jsonContent)
                    }
                }
            }
        }
        println("\n✅ Tous les cours ont été générés!")
    }
}
