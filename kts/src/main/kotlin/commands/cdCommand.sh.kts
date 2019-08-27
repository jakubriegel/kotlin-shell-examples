#!/usr/bin/env kshell

package commands

suspend fun Shell.pwd() { "echo ${env("PWD")}"() }

shell {
    pwd() // ../kts

    // change to relative directory
    cd("src")
    pwd() // ../kts/src

    // go one directory up [cd ..]
    cd(up)
    pwd() // ../kts

    // go to the previous directory [cd -]
    cd(pre)
    pwd() // ../kts/src

    // go to the user root [cd ~] or [cd]
    cd()
    pwd() // /user root/

    // go to the absolute directory
    cd("/bin")
    pwd() // /bin
}
