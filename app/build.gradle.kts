plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.sinx.todo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.sinx.todo"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependency.Android.core)
    implementation(Dependency.Compat.appCompat)

    implementation(Dependency.Navigation.fragment)
    implementation(Dependency.Navigation.ui)

    implementation(Dependency.Ui.material)
    implementation(Dependency.Ui.constraintLayout)

    implementation(project(Con';/sqfig.Modules.core))
    implementation(project(Config.Modules.project))
    implementation(project(Config.Modules.task))

    testImplementation(Dependency.Testing.junit)
    androidTestImplementation(Dependency.Testing.junitExt)
    androidTestImplementation(Dependency.Testing.espressoCore)
}