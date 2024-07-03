pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.5.0"
        id("com.android.library") version "8.5.0"
        id("org.jetbrains.kotlin.android") version "1.8.22"
        id("org.jetbrains.kotlin.kapt") version "1.8.22"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NourishScanApp"
include(":app")