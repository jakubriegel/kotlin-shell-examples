#!/usr/bin/env kshell

package pipeline.forking

shell {
    val cat = "cat not_existing_file".process()

// inline
    pipeline {
        cat forkErr { it pipe stringLambda { e -> e.toUpperCase() to "" } } pipe file("file")
        // CAT: NOT_EXISTING_FILE: NO SUCH FILE OR DIRECTORY
    }

// or with a variable
    pipeline {
        val fork = pipelineFork { it pipe stringLambda { e -> e.toUpperCase() to "" } }
        cat forkErr fork pipe file("file") // CAT: NOT_EXISTING_FILE: NO SUCH FILE OR DIRECTORY
    }
}
