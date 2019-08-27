#!/usr/bin/env kshell

package subshells

shell {
    println(env("ONE")) // /nothing/
    println(env("TWO")) // /nothing/

    shell (
        vars = mapOf("ONE" to "1", "TWO" to "2")
    ) {
        println(env("ONE")) // 1
        println(env("TWO")) // 2
    }
}
