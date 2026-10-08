package com.pionier.languages.utils

object Scoring {
    fun scoreToPercent(score: Int, total: Int): Int {
        if (total <= 0) return 0
        return ((score.toDouble() / total.toDouble()) * 100).toInt()
    }

    fun evaluateLesson(score: Int, total: Int): LessonEvaluation {
        val percent = scoreToPercent(score, total)
        val passed = score >= (total * 0.6).toInt()
        val message = if (passed) {
            "Cours assimilé ✅"
        } else {
            "Cours non assimilé ❌ - L'IA va vous orienter sur ce qui n'a pas marché"
        }
        return LessonEvaluation(total, score, percent, passed, message)
    }

    fun evaluateLevel(score: Int, total: Int): LevelEvaluation {
        val percent = scoreToPercent(score, total)
        val passed = score >= (total * 0.75).toInt()
        val message = if (passed) {
            "Test de niveau réussi ✅"
        } else {
            "Vous n'avez pas eu votre test, repasser le test ❌"
        }
        return LevelEvaluation(total, score, percent, passed, message)
    }
}

data class LessonEvaluation(
    val total: Int,
    val score: Int,
    val percent: Int,
    val passed: Boolean,
    val message: String
)

data class LevelEvaluation(
    val total: Int,
    val score: Int,
    val percent: Int,
    val passed: Boolean,
    val message: String
)
