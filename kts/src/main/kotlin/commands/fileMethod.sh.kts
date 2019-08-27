#!/usr/bin/env kshell

package commands

shell {
    cd("src/main/resources/res/def")

    // get existing file
    val abc = file("abc")
    println(abc.readText()) // ABCDEFGHIJKLMNOPQRSTUVWXYZ

    // create new  empty file
    val def = file("def")
    println(def.readText()) // /nothing/

    // create new file with given content
    val ghi = file("ghi", "content")
    println(ghi.readText()) // content

    def.delete()
    ghi.delete()
}

