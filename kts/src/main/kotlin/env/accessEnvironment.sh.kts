#!/usr/bin/env kshell

package env

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
