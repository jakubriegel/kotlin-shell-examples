#!/usr/bin/env kshell

package pipeline

// inline

pipeline {
    "cat not_existing_file".process() forkErr { it pipe stringLambda { e -> e.toUpperCase() to "" } } pipe file("file")
}

// or with variables

pipeline {
    val cat = "cat not_existing_file".process()
    val fork = pipelineFork { it pipe stringLambda { e -> e.toUpperCase() to "" } }
    cat forkErr fork pipe file("file")
}
