package eu.jrie.jetbrains.kotlinshell.examples.kotlin.basic

import eu.jrie.jetbrains.kotlinshell.shell.shell
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
fun main(args: Array<String>) = runBlocking {
    shell (
        scope = this
    ) {
        "echo ${args.joinToString(" ")}"()
    }
}
