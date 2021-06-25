plugins {
    id(Plugins.COMMON)
}

android {
    defaultConfig {
        buildConfigField("String", "ANOTHER_EXAMPLE", "\"I\'m specific to this module!\"")
    }
}
