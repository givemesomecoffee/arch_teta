import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 *  plugins {
 *      `kotlin-dsl`
 *  }
 *
 *  repositories {
 *      jcenter()
 *  }
 *
 * this class used as box for gradle.kts files
 * this class need to be in buildSrc/src/main/kotlin/Config.kt
 * this module need to have raw in this build.gradle.kts
 *
 * more func may to find:
 * https://medium.com/swlh/efficiently-create-multi-module-android-project-with-custom-plugin-7632a8b6f325
 */

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.kotlin.dsl.DependencyHandlerScope


//system
const val gradleConfVer = "4.1.2"
const val minSdkVersionConf = 21
const val compileSdkVersionConf = 30
const val appVersionCodeConf = 1
const val appVersionNameConf = "1.0.0"
const val appIdConf = "com.example.new.dagger_arch"
const val testInstrumentRunnerConf = "androidx.test.runner.AndroidJUnitRunner"
const val applicationIdSuffixConf = ".dev"
const val versionNameSuffixConf = "-dev"

//androidMaterial
const val materialVer = "1.3.0"
const val constraintLayoutVer = "2.0.4"
const val materialDateTimePickerVer = "4.2.1"

//kotlin
const val kotlinVer = "1.4.10"
const val ktxVer = "1.3.2"
const val coroutinesVer = "1.4.2"

//tests
const val junitVer = "4.12"
const val junitTestVer = "1.1.2"
const val espressoVer = "3.3.0"
const val kaspressoVer = "1.2.0"

//dagger
const val daggerVer = "2.36"
const val jsr250Ver = "1.0"

//JavaRx
const val rxJavaVer = "2.2.19"
const val rxAndroidVer = "2.1.1"

const val rxLintVer = "1.7.7"
const val rxJava2ExtentionVer = "0.20.10"

//lottie
const val lottieVer = "3.1.0"

//network
const val squareupOkhttpVer = "4.9.0"
const val retrofitVer = "2.9.0"

//picasso
const val squareupPicassoVer = "2.71828"

//video
const val youtubeVer = "1.2.2"
const val exoplayerVer = "2.11.8"

//lint
const val lintVer = "26.5.1"

//websocket
const val websocketVer = "2.6"

//androidX
const val lifecycleVer = "2.3.0"
const val fragmentsXVer = "1.2.5"
const val legacyVer = "1.0.0"
const val lifecycleExtVer = "2.2.0"

//common
const val timberVer = "4.7.1"

val androidXLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    //put("fileTree", Pair(fileTreeFromConfig(mapOf("dir" to "libs", "include" to listOf("*.jar")))!!, "implementation"))
    put("timber", Pair("com.jakewharton.timber:timber:$timberVer", "implementation"))
    put("lifecycle", Pair("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVer", "implementation"))
    put("fragmentsX", Pair("androidx.fragment:fragment-ktx:$fragmentsXVer", "implementation"))
    put("legacy", Pair("androidx.legacy:legacy-support-v4:$legacyVer", "implementation"))
    put("lifecycleExtVer", Pair("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleExtVer", "implementation"))
    put("constraintlayout", Pair("androidx.constraintlayout:constraintlayout:$constraintLayoutVer", "implementation"))
}

val retrofitAndOkHttpLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    //retrofit
    put("core", Pair("com.squareup.retrofit2:retrofit:$retrofitVer", "implementation"))
    put("gson", Pair("com.squareup.retrofit2:converter-gson:$retrofitVer", "implementation"))
    put("moshi", Pair("com.squareup.retrofit2:converter-moshi:$retrofitVer", "implementation"))
    put("rxJava2", Pair("com.squareup.retrofit2:adapter-rxjava2:$retrofitVer", "implementation"))
    put("mock", Pair("com.squareup.retrofit2:retrofit-mock:$retrofitVer", "testImplementation"))
    put("scalar", Pair("com.squareup.retrofit2:converter-scalars:$retrofitVer", "implementation"))
    //OkHttp3
    put("okHttp", Pair("com.squareup.okhttp3:okhttp:$squareupOkhttpVer", "implementation"))
    put("loggingInterceptor", Pair("com.squareup.okhttp3:logging-interceptor:$squareupOkhttpVer", "implementation"))
    put("urlConnection", Pair("com.squareup.okhttp3:okhttp-urlconnection:$squareupOkhttpVer", "implementation"))
}

val androidMaterial = mutableMapOf<String, Pair<Any, String>>().apply {
    put("material", Pair("com.google.android.material:material:$materialVer", "implementation"))
    put("constraintLayout", Pair("androidx.constraintlayout:constraintlayout:$constraintLayoutVer", "implementation"))
    put("dateTimePicker", Pair("com.wdullaer:materialdatetimepicker:$materialDateTimePickerVer", "implementation"))
}

val kotlinLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("kotlin", Pair("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVer", "implementation"))
    put("ktx", Pair("androidx.core:core-ktx:$ktxVer", "implementation"))
    put("coroutines", Pair("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVer", "implementation"))
    put("coroutinesAndroid", Pair("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVer", "implementation"))
    put("coroutinesTest", Pair("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVer", "testImplementation"))
}

val testLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("junit", Pair("junit:junit:$junitVer", "testImplementation"))
    put("junitAndroid", Pair("androidx.test.ext:junit:$junitTestVer", "androidTestImplementation"))
    put("espresso", Pair("androidx.test.espresso:espresso-core:$espressoVer", "androidTestImplementation"))
    put("kaspresso", Pair("com.kaspersky.android-components:kaspresso:$kaspressoVer", "testImplementation"))

}

val diLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("jsr250", Pair("javax.annotation:jsr250-api:$jsr250Ver", "compileOnly"))
    put("dagger", Pair("com.google.dagger:dagger:$daggerVer", "implementation"))
    put("daggerCompiler", Pair("com.google.dagger:dagger-compiler:$daggerVer", "kapt"))
    put("daggerAndroid", Pair("com.google.dagger:dagger-android:$daggerVer", "implementation"))
    put("daggerProcessorAndroid", Pair("com.google.dagger:dagger-android-processor:$daggerVer", "kapt"))
}

val javaRxLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("rxJava", Pair("io.reactivex.rxjava2:rxjava:$rxJavaVer", "implementation"))
    put("rxAndroid", Pair("com.google.dagger:dagger:$rxAndroidVer", "implementation"))
    put("rxLint", Pair("nl.littlerobots.rxlint:rxlint:$rxLintVer", "implementation"))
    put("rxJava2Extention", Pair("com.github.akarnokd:rxjava2-extensions:$rxJava2ExtentionVer", "implementation"))

}

val exoplayer = mutableMapOf<String, Pair<Any, String>>().apply {
    put("exoPlayerCore", Pair("com.google.android.exoplayer:exoplayer-core:$exoplayerVer", "implementation"))
    put("exoPlayerUi", Pair("com.google.android.exoplayer:exoplayer-ui:$exoplayerVer", "implementation"))
    put("exoPlayerHls", Pair("com.google.android.exoplayer:exoplayer-hls:$exoplayerVer", "implementation"))
    put("exoPlayerOkHttp", Pair("com.google.android.exoplayer:extension-okhttp:$exoplayerVer", "implementation"))
}

val lint = mutableMapOf<String, Pair<Any, String>>().apply {
    put("api", Pair("com.android.tools.lint:lint-api:$lintVer", "implementation"))
    put("checks", Pair("com.android.tools.lint:lint-checks:$lintVer", "implementation"))
    put("tests", Pair("com.android.tools.lint:lint-tests:$lintVer", "implementation"))
}

val lottie = Pair<Any, String>("com.airbnb.android:lottie:$lottieVer", "implementation")
val squareupPicasso = Pair<Any, String>("com.squareup.picasso:picasso:$squareupPicassoVer", "implementation")
val youtube = Pair<Any, String>("com.google.youtube:YouTubeAndroidPlayerApi:$youtubeVer", "implementation")
val websocket = Pair<Any, String>("com.neovisionaries:nv-websocket-client:$websocketVer", "implementation")

fun Project.initLibDependencies() {

    /**
     * Impl work as implementation operator
     *
     * @param depAndType Pair<String as "androidx.core:core-ktx:$ktxVer", String as "implementation">
     * @return [Dependency]
     */
    fun DependencyHandler.impl(depAndType: Pair<Any, String>): Dependency? {
        return project.let { add(depAndType.second, depAndType.first) }
    }


    /**
     * Impl map with libs
     *
     * @param map String as "kotlin", Pair<String as"androidx.core:core-ktx:$ktxVer",String as "implementation">
     */
    fun DependencyHandlerScope.implMap(map: Map<String, Pair<Any, String>>) {
        map.values.forEach { impl(it) }
    }

    /**
     * work as fileTree in function in gradle file
     * implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
     */

    fun fileTreeFromConfig(args: Map<String, *>): ConfigurableFileTree? =
        project.fileTree(args)

    dependencies {
        fileTreeFromConfig(mapOf("dir" to "libs", "include" to listOf("*.jar")))!!
        implMap(androidXLibs)
        implMap(androidMaterial)
        implMap(kotlinLibs)
        implMap(testLibs)
        implMap(diLibs)
        implMap(retrofitAndOkHttpLibs)
    }
}

