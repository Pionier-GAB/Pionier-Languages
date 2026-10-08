package com.pionier.languages.utils

import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Diploma(
    val language: String,
    val level: String,
    val score: Int,
    val obtainedDate: String,
    val timeSpentHours: Int
)

object DiplomaGenerator {
    
    fun generateDiploma(language: String, level: String, score: Int, timeSpentHours: Int = 0): Diploma {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val date = LocalDate.now().format(formatter)
        
        return Diploma(
            language = language,
            level = level,
            score = score,
            obtainedDate = date,
            timeSpentHours = timeSpentHours
        )
    }
    
    fun saveDiplomaToDisk(diploma: Diploma, storagePath: String) {
        val directory = File(storagePath)
        directory.mkdirs()
        
        val fileName = "diploma_${diploma.language}_${diploma.level}_${System.currentTimeMillis()}.txt"
        val file = File(directory, fileName)
        
        val content = """
        ╔════════════════════════════════════════╗
        ║          DIPLÔME DE RÉUSSITE            ║
        ╚════════════════════════════════════════╝
        
        Langue : ${diploma.language}
        Niveau : ${diploma.level}
        Score : ${diploma.score}%
        Date d'obtention : ${diploma.obtainedDate}
        Temps d'apprentissage : ${diploma.timeSpentHours} heures
        
        Ce diplôme certifie que l'utilisateur a réussi le test
        de niveau ${diploma.level} en ${diploma.language}.
        
        Pinoier-Languages - 2026
        """.trimIndent()
        
        file.writeText(content)
    }
    
    fun loadDiplomas(storagePath: String): List<Diploma> {
        val directory = File(storagePath)
        val diplomas = mutableListOf<Diploma>()
        
        if (directory.exists()) {
            directory.listFiles()?.forEach { file ->
                if (file.name.startsWith("diploma_")) {
                    // Parser le fichier et créer un objet Diploma
                    // Pour cet exemple, retourner une structure vide
                }
            }
        }
        
        return diplomas
    }
}
