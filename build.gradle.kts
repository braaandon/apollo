import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.5.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
	mavenCentral()
}

dependencies {
    implementation("net.java.dev.jna:jna:5.8.0")
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("apollo")
    mergeServiceFiles()
    manifest {
        attributes(mapOf("Main-Class" to "apollo.MainKt"))
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}