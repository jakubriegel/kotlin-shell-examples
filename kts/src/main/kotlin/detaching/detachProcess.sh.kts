#!/usr/bin/env kshell

package detaching

// with blocking api
val process = detach("echo hello".process()).first()
join(process)

// with non blocking api
shell {
    val echo = "echo hello".process()
    val process = detach(echo)
    process.join()
}
