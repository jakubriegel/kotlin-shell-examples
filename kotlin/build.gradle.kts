import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly(kotlin("reflect"))

    implementation("eu.jrie.jetbrains:kotlin-shell-core:0.")
    implementation("org.slf4j:slf4j-nop:1.7.27")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val sample: String? by project
val logs: String? by project

configurations.all {
    resolutionStrategy.dependencySubstitution {
        if (logs?.toBoolean() == true) {
            substitute(module("org.slf4j:slf4j-nop"))
                    .with(module("org.apache.logging.log4j:log4j-slf4j-impl:2.12.0"))
        }
    }
}

val execute by tasks.creating(JavaExec::class) {
    main = "${project.group}.kotlin.$sample"
    classpath = sourceSets["main"].runtimeClasspath
}
