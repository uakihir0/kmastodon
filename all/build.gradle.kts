import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.cocoapods)
}

kotlin {
    js(IR) {
        moduleName = "kmastodon-js"
        nodejs()
        browser()
        binaries.library()
        generateTypeScriptDefinitions()
    }

    val xcf = XCFramework("kmastodon")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        macosX64(),
        macosArm64(),
    ).forEach {
        it.binaries.framework {
            export(project(":core"))
            export(project(":stream"))
            baseName = "kmastodon"
            xcf.add(this)
        }
    }

    cocoapods {
        name = "kmisskey"
        version = "0.0.1"
        summary = "kmastodon is Mastodon library for Kotlin Multiplatform."
        homepage = "https://github.com/uakihir0/kmastodon"
        authors = "Akihiro Urushihara"
        license = "MIT"
        framework { baseName = "kmastodon" }
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }
        commonMain.dependencies {
            api(project(":core"))
            api(project(":stream"))
        }
    }
}

tasks.podPublishXCFramework {
    doLast {
        exec {
            executable = "sh"
            args = listOf("../tool/setup_pods.sh")
        }
    }
}

tasks.getByName("jsBrowserDevelopmentLibraryDistribution") {
    doLast {
        exec {
            executable = "sh"
            args = listOf("../tool/setup_js.sh")
        }
    }
}

