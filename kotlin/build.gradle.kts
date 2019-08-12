import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50-eap-54"
    application
}

group = "eu.jrie.jetbrains.kotlinshell.examples.kotlin"
version = "0.2"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
    maven("https://dl.bintray.com/jakubriegel/kotlin-shell")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("eu.jrie.jetbrains:kotlin-shell-core:0.1")
    implementation("org.slf4j:slf4j-nop:1.7.27")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val sampleClass: String? by project

val execute by tasks.creating(JavaExec::class) {
    main = "${project.group}.${sampleClass ?: null}"
    classpath = sourceSets["main"].runtimeClasspath
}
