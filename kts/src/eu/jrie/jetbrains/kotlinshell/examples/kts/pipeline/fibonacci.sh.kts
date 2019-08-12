#!/usr/bin/env kshell

@file:Suppress("UNRESOLVED_REFERENCE") // ProcessChannel and Channel are imported by default in sh.kts

package eu.jrie.jetbrains.kotlinshell.examples.kts.pipeline

val n = args.first().toInt()
val result: ProcessChannel = Channel(n)
val buffer: ProcessChannel = Channel(2)

shell {
    val fibonacci = contextLambda { ctx ->
        repeat(n) {
            val a = ctx.stdin.receive().readText().toLong()
            val b = ctx.stdin.receive()
                    .also { p -> ctx.stdout.send(p.copy()) }
                    .readText().toLong()

            packet("${a + b}").let { next ->
                ctx.stdout.send(next.copy())
                result.send(next)
            }

        }
        result.close()
    }

    buffer.apply {
        send(packet("0"))
        send(packet("1"))
    }

    detach { buffer pipe fibonacci pipe buffer }
    pipeline { result pipe stringLambda { "$it " to "" } }
}
