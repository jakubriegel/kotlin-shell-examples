#!/usr/bin/env kshell

package detaching

shell {
    val pipeline = detach { "echo hello".process() pipe "cat".process() }
    pipeline.join()
}

