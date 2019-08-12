package eu.jrie.jetbrains.kotlinshell.examples.kotlin.basic

import eu.jrie.jetbrains.kotlinshell.shell.shell
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    shell (
            scope = this
    ) {
        "echo hello world!"()
    }
}
