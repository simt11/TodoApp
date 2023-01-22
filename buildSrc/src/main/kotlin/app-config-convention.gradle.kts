import com.android.build.gradle.BaseExtension

extensions.configure<BaseExtension>("android") {
	namespace = "com.sinx.todo"
	compileSdkVersion(BuildVersions.compileSdk)

	defaultConfig {
		minSdk = BuildVersions.minSdk
		targetSdk = BuildVersions.targetSdk
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
}