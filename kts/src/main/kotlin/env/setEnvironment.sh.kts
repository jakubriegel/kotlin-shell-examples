#!/usr/bin/env kshell

package env

shell {
    // set shell environment variable that will be inherited to sub shells
    export("VAR_1" to "abc")
    // set shell variable that will not be inherited to sub shells
    variable("VAR_2" to "def")

    println(environment["VAR_1"]) // abc
    println(variables["VAR_2"]) // def

    // create sub shell
    shell {
        println(environment["VAR_1"]) // abc
        println(variables["VAR_2"]) // null

        variable("VAR_2" to "xyz")
        println(variables["VAR_2"]) // xyz
    }

    println(variables["VAR_2"]) // def

    // remove environment variable
    unset("VAR_2")
    println(variables["VAR_2"]) // null
}
