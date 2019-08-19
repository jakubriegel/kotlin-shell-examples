#!/usr/bin/env kshell
@file:Suppress("UNRESOLVED_REFERENCE", "OVERLOAD_RESOLUTION_AMBIGUITY") // intellij doesnt support highlighting @Depends on yet

@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-html-jvm:0.6.11")

package dependencies.external

import kotlinx.html.*
import kotlinx.html.stream.*
import org.jetbrains.kotlin.script.util.DependsOn
import org.jetbrains.kotlin.script.util.Repository

print(createHTML().html {
    body {
        h1 { +"Hello, World!" }
    }
})
