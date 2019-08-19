#!/usr/bin/env kshell

package pipeline

pipeline { "echo hello\nworld".process() pipe "grep w".process() }
