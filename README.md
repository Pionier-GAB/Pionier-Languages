# 🌍 Pionier-Languages

**Multiplatform Language Learning App avec IA Tutorielle, TTS Natif et Renforcement Cérébral**

Compilable pour :
- ✅ **Windows 10/11 x64** (EXE Kotlin Desktop)
- ✅ **Android 10+** (API 29+, APK)

Supportant **8 langues** :
- 🇬🇧 English (A1-C2 CEFR)
- 🇩🇪 Deutsch (A1-C2 Goethe)
- 🇫🇷 Français (A1-C2 CECR)
- 🇨🇳 中文 (1-6 HSK)
- 🇬🇦 Punu (A1-A2)
- 🇨🇲 Fang (A1-A2)
- 🇨🇬 Kota (A1-A2)
- 🇨🇬 Téké (A1-A2)

---

## 📋 Configuration requise

- **JDK** : 17+
- **Android SDK** : 29+
- **Gradle** : 8.1+
- **Kotlin** : 2.0.21+

---

## 🚀 Démarrage rapide

### 1️⃣ Cloner le repo

```bash
git clone https://github.com/Pionier-GAB/Pionier-Languages.git
cd Pionier-Languages
```

### 2️⃣ Créer la structure

```bash
chmod +x setup.sh
./setup.sh
```

### 3️⃣ Générer les cours JSON

```bash
./gradlew generateCourses
```

Ce script crée automatiquement **640 cours** :
- ✅ 480 cours (4 langues × 6 niveaux × 20 cours)
- ✅ 160 cours (4 langues bantu × 2 niveaux × 20 cours)

### 4️⃣ Ajouter les audios MP3

Placer les fichiers audio compressés :

```
content/langues/en/niveaux/A1/cours/01/audio.mp3
content/langues/*/niveaux/*/cours/*/audio.mp3
```

### 5️⃣ Compiler pour Android

```bash
./gradlew assembleDebug
```

Génère : `app/androidApp/build/outputs/apk/debug/app-debug.apk`

### 6️⃣ Compiler pour Windows

```bash
./gradlew desktopApp:packageExe
```

Génère : `app/desktopApp/build/compose/exes/PionierLanguages.exe`

---

## 📚 Structure des contenus

```
content/langues/
├─ en/de/fr/zh/punu/fang/kota/teke/
│  ├─ niveaux/
│  │  ├─ A1/A2/B1/B2/C1/C2/
│  │  │  └─ cours/
│  │  │     ├─ 01/
│  │  │     │  ├─ metadata.json
│  │  │     │  ├─ audio.mp3
│  │  │     │  ├─ transcript.txt
│  │  │     │  └─ reading.txt
│  │  │     ├─ 02/ ... 20/
│  │  └─ Niveau_1/Niveau_2/ (langues bantu)
│  └─ dictionaries/
│     ├─ bilingual/
│     └─ monolingual/
```

---

## 🎯 9 écrans principaux + Navigation

### 🏠 **Home Screen**
- Accueil avec boutons d'actions
- Commencer un cours
- Renforcement cérébral
- Dictionnaires
- Mes diplômes
- Paramètres

### 🌐 **Language Selection Screen**
- Sélection de la langue (8 langues)
- Drapeaux et labels
- Navigation vers niveaux

### 📖 **Course Screen**
- Contenu de leçon
- Vocabulaire avec transcription phonétique
- Grammaire avec explications
- Lecture avec TTS natif
- Exercices de rédaction avec correction IA
- Bouton "Démarrer le quiz"

### 🧪 **Quiz Screen**
- Questions dynamiques (5 questions/cours)
- 3 types : multiple choice, vrai/faux, réponses courtes
- Barre de progression
- Scoring automatique
- Résultats avec explication
- Messages conditionnels (Cours assimilé / Non assimilé)

### 📖 **Dictionary Screen**
- Recherche par mot
- Filtres : bilingue / monolingue
- Affichage des 8 langues
- Résultats avec définitions et traductions

### 🧠 **Brain Training Screen**
- 4 jeux de renforcement cérébral :
  - 🧠 Mémorisation
  - ⚡ Réaction
  - 🔮 Anticipation
  - 💡 Réflexion
- Bouton "Lancer" pour chaque jeu

### 🏆 **Profile/Diploma Screen**
- Diplômes obtenus
- Scores et dates
- Statistiques globales
- Temps d'apprentissage

### ⚙️ **Settings Screen**
- Thème sombre / blanc
- Son activé/désactivé
- Mode hors ligne
- À propos de l'app

### 🧭 **Navigation Bar**
- 5 onglets fixes
- Accueil | Langues | Dictionnaire | Cérébral | Profil

---

## 🤖 IA + TTS + LanguageTool

### TTS natif
- **Android** : `TextToSpeech` natif
- **Windows** : SAPI via PowerShell
- Support des 8 langues

### Correction grammaticale
- **Ktor Client** : Intégration LanguageTool
- Suggestions de correction en temps réel
- Support 8 langues

### Quiz dynamique
- Indépendant de l'audio
- 3 types de questions
- Scoring automatique :
  - Cours : 12/20 = 60% requis ("Cours assimilé")
  - Niveau : 15/20 = 75% requis ("Test de niveau réussi")

---

## 📖 Sources des contenus

**Légales et libres :**
- ✅ CEFR (Cadre Européen Commun de Référence)
- ✅ HSK Official Vocabulary List
- ✅ Goethe-Institut guidelines
- ✅ ALC (American Language Course)
- ✅ Public Domain
- ✅ Creative Commons

**Aucun contenu protégé reproduit intégralement.**

---

## 🔧 Développement

### Ajouter des audios

```bash
# Placer les fichiers MP3 compressés ici :
content/langues/en/niveaux/A1/cours/01/audio.mp3
```

### Générer les cours (Gradle)

```bash
./gradlew generateCourses
```

### Builder et tester

```bash
# Android
./gradlew :app:androidApp:installDebug
adb logcat

# Desktop
./gradlew :app:desktopApp:run
```

---

## 📁 Fichiers clés

```
app/
├─ composeApp/
│  ├─ src/commonMain/
│  │  ├─ model/          (Language, CourseMeta, QuizQuestion)
│  │  ├─ data/           (ContentRepository)
│  │  ├─ ai/             (TtsFacade, LanguageToolClient, QuizEngine)
│  │  ├─ screens/        (9 écrans Composables)
│  │  ├─ utils/          (Scoring, CourseGenerator)
│  │  └─ ui/theme/       (AppTheme, Colors)
│  ├─ src/androidMain/   (AndroidTts, MainActivity)
│  └─ src/desktopMain/   (DesktopTts, Main.kt)
├─ androidApp/           (AndroidManifest, MainActivity)
└─ desktopApp/           (Main.kt entry point)
```

---

## 🎓 Diplômes

Générés automatiquement :
- ✅ Après réussite d'un test de niveau (score ≥ 15/20)
- ✅ Format : Texte + statistiques
- ✅ Stockés localement avec date et score

---

## 📱 Plateforme

```
Kotlin Multiplatform (commonMain)
├─ Android (androidMain)
│  └─ API 29+ (Android 10+)
└─ Desktop/JVM (desktopMain)
   └─ Windows 10/11 x64

UI : Compose Multiplatform
Serialization : Kotlinx-Serialization (JSON)
HTTP : Ktor Client
Audio : Native TTS + MP3 support
```

---

## 📝 Licence

MIT License - Libre d'usage et de modification

---

## 🤝 Contribution

Domaines prioritaires :
- Enrichissement dictionnaires bantu
- Sources alternatives légales
- Amélioration TTS multilangue
- Tests et corrections de bugs
- Ajout de jeux pour le renforcement cérébral

---

## 👨‍💻 Auteur

**Pionier-GAB** - 2026

Basé sur : CEFR, HSK, Goethe-Institut, ALC, domaine public

---

### 🚀 Status : ✅ Production Ready

Dernière mise à jour : 2026-10-08

### 📞 Support

- 🐛 Issues : https://github.com/Pionier-GAB/Pionier-Languages/issues
- 📧 Email : contact@pionier-gab.dev
