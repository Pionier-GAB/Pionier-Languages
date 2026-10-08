package com.pionier.languages

import com.pionier.languages.ai.TtsFacade

actual class TtsFacade actual constructor() {
    actual fun speak(text: String) {
        try {
            val cmd = arrayOf(
                "powershell",
                "-Command",
                "Add-Type -AssemblyName System.Speech; " +
                        "\$s = New-Object System.Speech.Synthesis.SpeechSynthesizer; " +
                        "\$s.Speak('${text.replace("'", "''')}')"
            )
            Runtime.getRuntime().exec(cmd)
        } catch (_: Exception) {
            // fallback silencieux
        }
    }

    actual fun stop() { }

    actual fun setLanguage(languageCode: String) { }
}
