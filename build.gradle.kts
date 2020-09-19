import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.mapstruct:mapstruct:1.4.0.CR1")
    kapt("org.mapstruct:mapstruct-processor:1.4.0.CR1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}