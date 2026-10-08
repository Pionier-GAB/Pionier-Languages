package com.pionier.languages.model

import kotlinx.serialization.Serializable

@Serializable
data class CourseMeta(
    val id: String,
    val language: String,
    val level: String,
    val courseNumber: Int,
    val title: String,
    val description: String = "",
    val audioPath: String = "",
    val transcriptPath: String = "",
    val readingPath: String = "",
    val speakingPrompt: String = "",
    val writingPrompt: String = "",
    val skills: List<String> = emptyList(),
    val tags: List<String> = emptyList(),
    val sourceNotes: List<String> = emptyList(),
    val cefr: String = "A1",
    val hskLevel: Int = 0,
    val vocabulary: List<VocabularyItem> = emptyList(),
    val grammarPoints: List<GrammarPoint> = emptyList(),
    val quizQuestions: List<QuizQuestion> = emptyList()
)

@Serializable
data class VocabularyItem(
    val word: String,
    val partOfSpeech: String = "",
    val definition: String = "",
    val exampleSentence: String = "",
    val translation: String = "",
    val phonetic: String = ""
)

@Serializable
data class GrammarPoint(
    val rule: String,
    val explanation: String = "",
    val examples: List<String> = emptyList(),
    val difficulty: String = "basic"
)

@Serializable
data class QuizQuestion(
    val id: String,
    val type: String,
    val question: String,
    val correctAnswer: String,
    val options: List<String> = emptyList(),
    val explanation: String = "",
    val skill: String = "listening",
    val audioPath: String = ""
)
