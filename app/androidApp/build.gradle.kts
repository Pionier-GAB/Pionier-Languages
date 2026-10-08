plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.pionier.languages"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pionier.languages"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":app:composeApp"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
}
