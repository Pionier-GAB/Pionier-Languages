package com.pionier.languages.ai

import com.pionier.languages.model.CourseMeta
import com.pionier.languages.model.QuizQuestion

class QuizEngine {

    fun generateQuizFromCourse(course: CourseMeta?): List<QuizQuestion> {
        return course?.quizQuestions ?: emptyList()
    }

    fun evaluateAnswer(question: QuizQuestion, userAnswer: String): Boolean {
        return userAnswer.trim().equals(question.correctAnswer, ignoreCase = true)
    }

    fun evaluateLessonQuiz(
        questions: List<QuizQuestion>,
        answers: List<String>
    ): QuizResult {
        if (questions.size != answers.size) {
            return QuizResult(0, 0, 0, false, "Nombre de réponses incorrect")
        }

        var score = 0
        val details = mutableListOf<AnswerDetail>()

        questions.forEachIndexed { index, question ->
            val isCorrect = evaluateAnswer(question, answers[index])
            if (isCorrect) score++

            details.add(
                AnswerDetail(
                    questionId = question.id,
                    userAnswer = answers[index],
                    correctAnswer = question.correctAnswer,
                    isCorrect = isCorrect,
                    explanation = question.explanation
                )
            )
        }

        val percent = if (questions.isNotEmpty()) {
            ((score.toDouble() / questions.size.toDouble()) * 100).toInt()
        } else {
            0
        }

        val passed = score >= (questions.size * 0.6).toInt()

        return QuizResult(
            score = score,
            total = questions.size,
            percent = percent,
            passed = passed,
            message = if (passed) {
                "Cours assimilé ✅"
            } else {
                "Cours non assimilé ❌ - L'IA va vous orienter sur ce qui n'a pas marché"
            },
            details = details
        )
    }

    fun evaluateLevelTest(
        questions: List<QuizQuestion>,
        answers: List<String>
    ): LevelTestResult {
        if (questions.size != answers.size) {
            return LevelTestResult(0, 0, 0, false, "Nombre de réponses incorrect")
        }

        var score = 0
        val failedTopics = mutableListOf<String>()

        questions.forEachIndexed { index, question ->
            val isCorrect = evaluateAnswer(question, answers[index])
            if (isCorrect) score++ else failedTopics.add(question.skill)
        }

        val percent = if (questions.isNotEmpty()) {
            ((score.toDouble() / questions.size.toDouble()) * 100).toInt()
        } else {
            0
        }

        val passed = score >= (questions.size * 0.75).toInt()

        return LevelTestResult(
            score = score,
            total = questions.size,
            percent = percent,
            passed = passed,
            message = if (passed) {
                "Test de niveau réussi ✅"
            } else {
                "Vous n'avez pas eu votre test, repasser le test ❌"
            },
            failedTopics = failedTopics.distinct()
        )
    }
}

data class QuizResult(
    val score: Int,
    val total: Int,
    val percent: Int,
    val passed: Boolean,
    val message: String,
    val details: List<AnswerDetail> = emptyList()
)

data class AnswerDetail(
    val questionId: String,
    val userAnswer: String,
    val correctAnswer: String,
    val isCorrect: Boolean,
    val explanation: String
)

data class LevelTestResult(
    val score: Int,
    val total: Int,
    val percent: Int,
    val passed: Boolean,
    val message: String,
    val failedTopics: List<String> = emptyList()
)
