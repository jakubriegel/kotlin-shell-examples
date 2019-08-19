#!/usr/bin/env kshell

package basic

val extension = args.first()

pipeline {
    cd("src/resources/res/abc/xyz")
    val filter = stringLambda {
        (if (it.endsWith(extension.plus('\n'))) it.split(" ").last() else "") to ""
    }

    "ls -l".process() pipe filter
}
