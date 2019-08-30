#!/usr/bin/env kshell

package pipeline

shell {
    pipeline { "cat src/main/resources/lorem_ipsum".process() pipe stringLambda { it.toUpperCase() to "" } pipe file("result") }
}
