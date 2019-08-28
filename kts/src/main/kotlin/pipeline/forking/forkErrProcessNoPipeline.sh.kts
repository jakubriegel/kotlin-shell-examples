#!/usr/bin/env kshell

package pipeline.forking

shell {
    val cat = "cat not_existing_file".process() forkErr { it pipe stringLambda { e -> e.toUpperCase() to "" } }
    cat()
}
