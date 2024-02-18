val javaVersion = 17

val groupId = "loader"
val main = "IconBuilderKt"

plugins {
    kotlin("jvm") version "1.9.22"
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.jilence"
version = "1.0.4"

repositories {
    mavenCentral()
    mavenLocal()

    // PaperMC repository
    maven("https://repo.codemc.io/repository/maven-snapshots/")

    // PaperMC repository
    maven("https://repo.papermc.io/repository/maven-public")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    manifest {
        attributes["Main-Class"] = "com.jilence.$groupId.$main"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "$javaVersion"
        }
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(javaVersion)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.jilence"
            artifactId = "loader"
            version = "1.0.4"

            from(components["java"])
        }
    }
}
