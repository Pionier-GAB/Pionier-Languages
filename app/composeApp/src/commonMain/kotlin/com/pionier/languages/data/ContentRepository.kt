package com.pionier.languages.data

import com.pionier.languages.model.CourseMeta
import com.pionier.languages.model.Language
import kotlinx.serialization.json.Json
import java.io.File

class ContentRepository {
    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    fun loadCourse(language: Language, level: String, courseId: String): CourseMeta? {
        val metadataFile = File(
            "content/langues/${language.code}/niveaux/$level/cours/$courseId/metadata.json"
        )
        if (!metadataFile.exists()) {
            return null
        }

        return runCatching {
            json.decodeFromString(CourseMeta.serializer(), metadataFile.readText())
        }.getOrNull()
    }

    fun loadCoursesForLevel(language: Language, level: String): List<CourseMeta> {
        val folder = File("content/langues/${language.code}/niveaux/$level/cours")
        if (!folder.exists()) return emptyList()

        val courses = mutableListOf<CourseMeta>()
        (1..20).forEach { courseNum ->
            val courseFolder = File(folder, String.format("%02d", courseNum))
            val metadataFile = File(courseFolder, "metadata.json")
            if (metadataFile.exists()) {
                runCatching {
                    courses.add(
                        json.decodeFromString(
                            CourseMeta.serializer(),
                            metadataFile.readText()
                        )
                    )
                }
            }
        }
        return courses
    }
}
