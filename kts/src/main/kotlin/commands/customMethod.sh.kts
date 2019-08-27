#!/usr/bin/env kshell

package commands

suspend fun Shell.pwd() { "echo ${env("PWD")}"() }

shell {
    pwd()
}
