// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
	repositories {
		google()
		mavenCentral()
	}
	dependencies {
		classpath("com.android.tools.build:gradle:${Config.Plugins.Versions.gradleVersion}")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Config.Plugins.Versions.kotlinAndroidVersion}")
	}
}

plugins {
	id(Config.Plugins.androidApplication) apply false
	id(Config.Plugins.androidLibrary) apply false
	id(Config.Plugins.androidKotlin) apply false
}
