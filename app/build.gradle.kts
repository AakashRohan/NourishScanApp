plugins {
    id("com.android.application")
    kotlin("android") version "1.9.0"
}

android {
    namespace = "com.example.nourishscanapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.nourishscanapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidxCore)
    implementation(libs.lifecycleRuntime)
    implementation(libs.activityCompose)
    implementation(libs.composeUi)
    implementation(libs.composeMaterial)
    implementation(libs.composeMaterial3)
    implementation(libs.composeUiToolingPreview)
    implementation(libs.accompanistPermissions)
    implementation(libs.accompanistNavigationAnimation)
    implementation(libs.navigationCompose)
    implementation(libs.zxingCore)
    implementation(libs.zxingAndroidEmbedded)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidxJunit)
    androidTestImplementation(libs.espressoCore)
    androidTestImplementation(libs.composeUiTestJunit4)
    debugImplementation(libs.composeUiTooling)
    debugImplementation(libs.composeUiTestManifest)
    implementation(libs.composeFoundation)
    implementation(libs.composeRuntime)
}