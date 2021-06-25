plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // This should be in-sync with the Gradle version exposed by `Versions.kt`
    implementation("com.android.tools.build:gradle:4.2.1")

    // This should be in-sync with the Kotlin version exposed by `Versions.kt`
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")

    implementation(kotlin("script-runtime"))
}
