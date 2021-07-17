import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.5.20"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("apollo.MainKt")
}

dependencies {
    implementation("net.java.dev.jna:jna:5.8.0")
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