import org.jetbrains.kotlin.scripting.definitions.StandardScriptDefinition.template

val javaVersion = 17 // Minecraft 1.18 requires Java 17

val groupId = "template"
val main = "TemplateKt"

plugins {
    kotlin("jvm") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.jilence"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    manifest {
        attributes["Main-Class"] = "com.jilence.$groupId.$main"
    }
}

dependencies {

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

