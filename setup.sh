#!/bin/bash

set -e

echo "🚀 Initialisation de Pionier-Languages..."

# Créer les répertoires Gradle
mkdir -p gradle
mkdir -p app/composeApp/src/{commonMain,androidMain,desktopMain}/kotlin/com/pionier/languages/{model,data,ai,screens,ui/theme,utils}
mkdir -p app/composeApp/src/{commonMain,androidMain,desktopMain}/resources
mkdir -p app/androidApp/src/main/{java/com/pionier/languages,res/values}
mkdir -p app/desktopApp/src/main/kotlin/com/pionier/languages

echo "📚 Création de la structure des langues et niveaux..."

for lang in en de fr zh punu fang kota teke; do
  for level in A1 A2 B1 B2 C1 C2; do
    for i in {01..20}; do
      mkdir -p "content/langues/$lang/niveaux/$level/cours/$i"
    done
  done
  mkdir -p "content/dictionaries/$lang/bilingual"
  mkdir -p "content/dictionaries/$lang/monolingual"
done

echo "📁 Création des fichiers Android resources..."
mkdir -p app/androidApp/src/main/res/values

echo "✅ Structure créée avec succès!"
echo ""
echo "📝 Prochaines étapes :"
echo "  1. cd Pionier-Languages"
echo "  2. chmod +x gradlew"
echo "  3. ./gradlew build"
echo "  4. ./gradlew generateCourses"
echo "  5. Ajouter les audios MP3 : content/langues/*/niveaux/*/cours/*/audio.mp3"
echo "  6. ./gradlew assembleDebug (Android)"
echo "  7. ./gradlew desktopApp:packageExe (Windows)"
echo ""