@file:JvmName("Deps")

object Versions {
    const val composeCompilerVersion = "1.4.0"
    const val compose = "1.0.0-alpha03"
    const val kotlin = "1.4.10"
    const val targetSdk = 30
    const val buildVersion = "30"
}

object Compose {
    const val animation = "androidx.compose.animation:animation:${Versions.compose}"
    const val core = "androidx.compose.ui:ui:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val materialIconsExt = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val tooling = "androidx.ui:ui-tooling:${Versions.compose}"
}

object Android {
    const val appcompat = "androidx.appcompat:appcompat:1.1.0"
}

object Kotlin {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
}