#!/usr/bin/env kshell

package detach

// with non blocking api
shell {
    val pipeline = detach { "echo hello".process() pipe "cat".process() }
    pipeline.join()
}

