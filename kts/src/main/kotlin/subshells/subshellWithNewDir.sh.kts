#!/usr/bin/env kshell

package subshells

shell {
    "echo ${env("PWD")}"() // ../kts
    "ls -l"()

    shell (
            dir = file("src/main/resources")
    ) {
        "echo ${env("PWD")}"() // ../kts/src/main/resources
        "ls -l"()
    }
}
