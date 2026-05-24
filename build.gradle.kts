plugins {
    alias(libs.plugins.bit.convention)
}

group = "xyz.orbitary"
version = "0.1.0"

allprojects {
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    repositories {
        mavenLocal()
        uri("https://repo.bitsquidd.xyz/repository/bit/")
        mavenCentral()
    }

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
}