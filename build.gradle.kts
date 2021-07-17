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
	implementation(platform("org.lwjgl:lwjgl-bom:3.2.3"))

	implementation("org.lwjgl", "lwjgl")
	implementation("org.lwjgl", "lwjgl-assimp")
	implementation("org.lwjgl", "lwjgl-glfw")
	implementation("org.lwjgl", "lwjgl-opengl")
	implementation("org.lwjgl", "lwjgl-stb")
	runtimeOnly("org.lwjgl", "lwjgl", classifier = "natives-linux")
	runtimeOnly("org.lwjgl", "lwjgl-assimp", classifier = "natives-linux")
	runtimeOnly("org.lwjgl", "lwjgl-glfw", classifier = "natives-linux")
	runtimeOnly("org.lwjgl", "lwjgl-opengl", classifier = "natives-linux")
	runtimeOnly("org.lwjgl", "lwjgl-stb", classifier = "natives-linux")
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