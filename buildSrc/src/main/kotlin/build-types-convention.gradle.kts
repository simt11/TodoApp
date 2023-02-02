import com.android.build.gradle.BaseExtension

/*
* Можно писать так же extensions:
* fun Project.android(configure: BaseExtension.()->Unit) = extensions.configure("android", configure)
*
* android { }
* */

extensions.configure<BaseExtension>("android") {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}