#!/usr/bin/env kshell

package subshells

shell {
    export("ONE" to "1")
    variable("TWO" to "2")

    shell {
        println(env("ONE")) // 1
        println(env("TWO")) // /nothing/

        shell {
            println(env("ONE")) // 1
            println(env("TWO")) // /nothing/
        }
    }

    "echo sub shells ended"()
}
