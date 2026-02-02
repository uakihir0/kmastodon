import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.cocoapods)
}

kotlin {
    js(IR) {
        nodejs()
        browser()
        binaries.library()
        generateTypeScriptDefinitions()

        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    moduleName.set("kmastodon-js")
                }
            }
        }
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
        name = "kmastodon"
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

multiplatformSwiftPackage {
    swiftToolsVersion("5.7")
    targetPlatforms {
        // baseline 2020
        iOS { v("15") }
        macOS { v("12.0") }
    }
}

tasks.configureEach {
    // Fix implicit dependency between XCFramework and FatFramework tasks
    if (name.contains("assembleKmastodon") && name.contains("XCFramework")) {
        mustRunAfter(tasks.matching { it.name.contains("FatFramework") })
    }
}

tasks.podPublishXCFramework {
    doLast {
        providers.exec {
            executable = "sh"
            args = listOf(project.projectDir.path + "/../tool/rename_podfile.sh")
        }.standardOutput.asText.get()
    }
}
