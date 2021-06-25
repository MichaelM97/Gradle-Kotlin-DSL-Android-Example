import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {
    object Kotlin {
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:${Versions.AndroidX.CORE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Versions.Google.MATERIAL}"
    }

    object Test {
        object Unit {
            const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        }

        object Integration {
            const val JUNIT = "androidx.test.ext:junit:${Versions.Test.JUNIT_INTEGRATION}"
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
        }
    }

    fun DependencyHandlerScope.common() {
        "implementation"(Kotlin.STDLIB)
        "implementation"(AndroidX.CORE)
    }

    fun DependencyHandlerScope.commonIntegrationTest() {
        "androidTestImplementation"(Test.Integration.JUNIT)
        "androidTestImplementation"(Test.Integration.ESPRESSO_CORE)
    }
}
