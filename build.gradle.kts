plugins {
    alias(libs.plugins.bit.convention)
}

group = "xyz.orbitary"
version = "0.0.1"

allprojects {
    group = rootProject.group
    version = rootProject.version

    dependencies {
        api("com.squareup.okhttp3:okhttp:4.12.0")
        implementation(libs.bits.api)
    }

    publishing {
        repositories {
            maven {
                url = uri("https://repo.bitsquidd.xyz/repository/bit/")
                credentials {
                    username = System.getenv("MAVEN_USERNAME")
                    password = System.getenv("MAVEN_PASSWORD")
                }
            }
        }
    }

    java {
        toolchain.languageVersion = JavaLanguageVersion.of(21)
    }
}