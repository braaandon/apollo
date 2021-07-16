group = "apollo"
version = "1.0-SNAPSHOT"

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