#!/usr/bin/env kshell

package pipeline.forking

val cat = "cat not_existing_file".process()

// inline
pipeline {
    cat forkErr { it pipe stringLambda { e -> e.toUpperCase() to "" } } pipe file("file")
}

// or with a variable
pipeline {
    val fork = pipelineFork { it pipe stringLambda { e -> e.toUpperCase() to "" } }
    cat forkErr fork pipe file("file")
}
