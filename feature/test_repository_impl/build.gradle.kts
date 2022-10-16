plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    compileSdk = rootProject.extra["compileSdkVersion"] as Int
    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

initLibDependencies()
dependencies {
    implementation(project(":feature:test_repository_api1"))
    implementation(project(":core:networkapi"))
    implementation(project(":core:commonapi"))
    implementation(project(":core:modulinjection"))

}

