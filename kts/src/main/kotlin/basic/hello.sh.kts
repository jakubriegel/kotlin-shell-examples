#!/usr/bin/env kshell

package basic

shell {
    "echo hello world!"()
}

// or non suspending

"echo hello world!".process().run()
