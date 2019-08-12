#!/usr/bin/env kshell

package eu.jrie.jetbrains.kotlinshell.examples.kts

import eu.jrie.jetbrains.kotlinshell.shell.up

shell {
    cd("resources")
    file("res").deleteRecursively()

    val loremIpsum = StringBuilder().let {
        pipeline { "cat lorem_ipsum".process() pipe it }
        it.toString()
    }

    // abc
    mkdir("res/abc/xyz")
    cd("res/abc/xyz")

    suspend fun lorem(name: String) {
        pipeline { loremIpsum pipe file(name) }
    }
    repeat(100) { lorem("lorem_$it.txt") }
    repeat(20) { lorem("ipsum_$it.txt") }
    repeat(10) { lorem("text_$it") }

    cd(up)
    cd(up)

    // def
    mkdir("def")
    cd("def")

    val alphabet = contextLambda { ctx ->
        repeat(26) { ctx.stdout.send(packet("${(65 + it).toChar()}")) }
    }
    alphabet pipeAppend file("abc")

    cd(up)

    // ghi
    mkdir("ghi")
}
