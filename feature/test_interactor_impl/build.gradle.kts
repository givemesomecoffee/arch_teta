plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android{
    compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }//need to use viewModel
}

initLibDependencies()

dependencies {
    implementation(project(":feature:test_interactor_api1"))
    implementation(project(":feature:test_repository_api1"))
    implementation(project(":core:modulinjection"))
}