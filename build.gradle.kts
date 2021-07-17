import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.5.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.jonatino:Java-Memory-Manipulation:2.1.2")
}

application {
    mainClass.set("apollo.MainKt")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "apollo.MainKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }

    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}