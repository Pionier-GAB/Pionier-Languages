package com.pionier.languages.ai

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class LanguageToolClient {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun checkText(text: String, languageCode: String = "en-US"): String {
        return try {
            val response: HttpResponse = client.post("https://languagetool.org/api/v2/check") {
                contentType(ContentType.Application.Json)
                setBody(
                    mapOf(
                        "text" to text,
                        "language" to languageCode,
                        "enabledOnly" to false
                    )
                )
            }
            response.readText()
        } catch (e: Exception) {
            "{\"matches\": []}"
        }
    }
}
