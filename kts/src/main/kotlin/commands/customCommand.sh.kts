#!/usr/bin/env kshell

package commands

val Shell.pwd: ShellCommand
    get() = command {
        val builder = StringBuilder()
        pipeline { "echo ${env("PWD")}".process() pipe builder }
        builder.toString()
    }

shell {
    pwd()
    shell {
        pwd()
        pipeline { pwd pipe stringLambda { it.toUpperCase() to "" } }
    }
}
