package com.pionier.languages

import android.content.Context
import android.speech.tts.TextToSpeech
import com.pionier.languages.ai.TtsFacade
import java.util.Locale

actual class TtsFacade actual constructor() : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null

    fun bind(context: Context) {
        tts = TextToSpeech(context.applicationContext, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.language = Locale.US
        }
    }

    actual fun speak(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "pionier")
    }

    actual fun stop() {
        tts?.stop()
    }

    actual fun setLanguage(languageCode: String) {
        val locale = when (languageCode.lowercase()) {
            "en" -> Locale.US
            "de" -> Locale.GERMANY
            "fr" -> Locale.FRANCE
            "zh" -> Locale.CHINA
            else -> Locale.US
        }
        tts?.language = locale
    }
}
