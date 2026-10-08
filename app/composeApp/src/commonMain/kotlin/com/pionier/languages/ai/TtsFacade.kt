package com.pionier.languages.ai

expect class TtsFacade() {
    fun speak(text: String)
    fun stop()
    fun setLanguage(languageCode: String)
}
