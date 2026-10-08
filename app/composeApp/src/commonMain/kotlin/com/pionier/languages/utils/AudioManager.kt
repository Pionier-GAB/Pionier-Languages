package com.pionier.languages.utils

import com.pionier.languages.ai.TtsFacade
import java.io.File

class AudioManager(private val ttsFacade: TtsFacade) {
    
    fun playAudioFile(audioPath: String) {
        val file = File(audioPath)
        if (file.exists()) {
            // Placer la logique de lecture du fichier audio MP3
            // Android : MediaPlayer
            // Desktop : JavaFX MediaPlayer
        }
    }
    
    fun playTextToSpeech(text: String, languageCode: String = "en") {
        ttsFacade.setLanguage(languageCode)
        ttsFacade.speak(text)
    }
    
    fun stopAudio() {
        ttsFacade.stop()
    }
    
    fun getAudioDuration(audioPath: String): Int {
        // Retourner la durée en secondes
        return 0
    }
}
