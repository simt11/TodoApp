import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // Версия должна быть такая же как у Gradle в`Config.Plugins.Versions.kt`
    implementation("com.android.tools.build:gradle:7.3.1")

    // Версия должна быть такая же как у Kotlin в `Config.Plugins.Versions.kt`
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")

    implementation(kotlin("script-runtime"))
}