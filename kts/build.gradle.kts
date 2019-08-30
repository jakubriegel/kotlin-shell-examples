plugins {
    kotlin("jvm")
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly(kotlin("reflect"))
    implementation(kotlin("script-runtime"))

    implementation("eu.jrie.jetbrains:kotlin-shell-kts:0.2")
}
