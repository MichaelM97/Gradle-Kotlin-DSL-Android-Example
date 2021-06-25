import Dependencies.common

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.App.COMPILE_SDK)

    defaultConfig {
        minSdkVersion(Versions.App.MIN_SDK)
        targetSdkVersion(Versions.App.TARGET_SDK)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    kotlinOptions {
        jvmTarget = Versions.JAVA.toString()
    }
}

dependencies {
    common()
    testImplementation(Dependencies.Test.Unit.JUNIT)
}
