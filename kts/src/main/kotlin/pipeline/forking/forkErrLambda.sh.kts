#!/usr/bin/env kshell

package pipeline.forking

shell {
    val lambda = stringLambda { "std\n" to "err\n" }

    // inline
    pipeline {
        lambda forkErr { it pipe stringLambda { e -> e.toUpperCase() to "" } } pipe file("file")
    }

    // or with a variable
    pipeline {
        val fork = pipelineFork { it pipe stringLambda { e -> e.toUpperCase() to "" } }
        lambda forkErr fork pipe file("file")
    }
}

