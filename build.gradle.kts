val javaVersion = 17 // Minecraft 1.18 requires Java 17

plugins {
    kotlin("jvm") version "1.6.21"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("xyz.jpenilla.run-paper") version "1.0.6"
}

group = "com.jilence"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.codemc.io/repository/maven-snapshots/")
    maven("https://repo.papermc.io/repository/maven-public")
}

dependencies {
    // PaperMC dependency
    implementation("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")

    // KSpigot dependency
    implementation("net.axay:kspigot:1.18.2")

    // AnvilGUI dependency
    implementation("net.wesjd:anvilgui:1.5.3-SNAPSHOT")
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