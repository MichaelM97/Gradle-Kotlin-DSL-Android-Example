import Dependencies.common
import Dependencies.commonIntegrationTest

plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
    kotlin(Plugins.KOTLIN_ANDROID_EXTENSIONS)
}

android {
    compileSdkVersion(Versions.App.COMPILE_SDK)

    defaultConfig {
        applicationId = "com.michaelmccormick.gradlekotlindslandroidexample"

        minSdkVersion(Versions.App.MIN_SDK)
        targetSdkVersion(Versions.App.TARGET_SDK)

        versionCode = Versions.App.VERSION_CODE
        versionName = Versions.App.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            keyAlias = "MyKeyAlias"
            keyPassword = "MyKeyPassword"
            storeFile = file("Path/To/Key")
            storePassword = "KeyStorePassword"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            buildConfigField("String", "EXAMPLE", "\"release\"")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            buildConfigField("String", "EXAMPLE", "\"debug\"")
        }
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    kotlinOptions {
        jvmTarget = Versions.JAVA.toString()
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(Modules.FEATURE1))
    implementation(project(Modules.FEATURE2))

    common()
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.Google.MATERIAL)

    testImplementation(Dependencies.Test.Unit.JUNIT)

    commonIntegrationTest()
}
