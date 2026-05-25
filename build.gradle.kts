plugins {
    alias(libs.plugins.bit.convention)
}

group = "xyz.orbitary.notion"
version = property("version") as String

allprojects {
    group = rootProject.group
    version = rootProject.version

    dependencies {
        api(rootProject.libs.okhttp)
        implementation(rootProject.libs.bits.api)
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