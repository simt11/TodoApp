plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.androidKotlin)

    id(Config.Plugins.conventionAppConfig)
    id(Config.Plugins.conventionBuildTypes)
    id(Config.Plugins.conventionKotlin)

    id(Config.Plugins.kotlinKapt)
}

dependencies {
    implementation(Dependency.Android.core)
    implementation(Dependency.Compat.appCompat)
    implementation(project(Config.Modules.core))

    implementation(Dependency.Navigation.fragment)
    implementation(Dependency.Navigation.ui)

    implementation(Dependency.Ui.material)
    implementation(Dependency.Ui.recyclerView)

    testImplementation(Dependency.Testing.junit)
    androidTestImplementation(Dependency.Testing.junitExt)
    androidTestImplementation(Dependency.Testing.espressoCore)

    implementation(Dependency.Dagger.dagger)
    kapt(Dependency.Dagger.daggerCompiler)
}