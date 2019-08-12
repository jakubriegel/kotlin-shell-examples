#!/usr/bin/env kshell

package eu.jrie.jetbrains.kotlinshell.examples.kts.env

shell {
    // print system environment
    env()
    "echo ---"()
    // print shell environment
    set()

    //
    systemEnv

    // get shell environment as map
    environment["PWD"]
}
