#!/usr/bin/env kshell

package eu.jrie.jetbrains.kotlinshell.examples.kts.pipeline

pipeline { "echo hello\nworld".process() pipe "grep w".process() }
