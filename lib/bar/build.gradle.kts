plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

apply(from = rootProject.file("gradle/configure-android.gradle"))
apply(from = rootProject.file("gradle/configure-compose.gradle"))

dependencies {
    implementation(Kotlin.stdLib)

    implementation(Compose.animation)
    implementation(Compose.core)
    implementation(Compose.layout)
    implementation(Compose.foundation)
    implementation(Compose.material)
    implementation(Compose.runtime)
    debugImplementation(Compose.tooling)
}