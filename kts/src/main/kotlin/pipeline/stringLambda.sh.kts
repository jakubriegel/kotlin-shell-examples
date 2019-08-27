#!/usr/bin/env kshell

package pipeline

shell {
    val upper = stringLambda { it.toUpperCase() to "" }
    pipeline { "cat src/main/resources/lorem_ipsum".process() pipe upper pipe file("result") }
}
