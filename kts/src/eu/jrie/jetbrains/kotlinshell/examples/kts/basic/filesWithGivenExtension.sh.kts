#!/usr/bin/env kshell

package eu.jrie.jetbrains.kotlinshell.examples.kts.basic

val extension = args.first()

pipeline {
    cd("src/resources/res/abc/xyz")
    val filter = stringLambda {
        (if (it.endsWith(extension.plus('\n'))) it.split(" ").last() else "") to ""
    }

    "ls -l".process() pipe filter
}
