#!/usr/bin/env kshell

package pipeline

import kotlinx.io.core.buildPacket

val text = "heLlo WorLd\n"

// top level function
suspend fun toUpperTop(ctx: ExecutionContext) {
    ctx.stdin.consumeEach { p ->
        p.readText()
                .toUpperCase()
                .let { ctx.stdout.send(buildPacket { writeText(it) }) }
    }
}

shell {
    pipeline { text pipe ::toUpperTop } // HELLO WORLD
}

// top level shell function
shell {

    suspend fun toUpperShell(ctx: ExecutionContext) {
        ctx.stdin.consumeEach { p ->
            p.readText()
                    .toUpperCase()
                    .let { ctx.stdout.send(packet(it)) }
        }
    }


    pipeline { text pipe ::toUpperShell } // HELLO WORLD
}

// member function
object ShellUtils {
    suspend fun toUpperMember(ctx: ExecutionContext) {
        ctx.stdin.consumeEach { p ->
            p.readText()
                    .toUpperCase()
                    .let { ctx.stdout.send(buildPacket { writeText(it) }) }
        }
    }
}

shell {
    pipeline { text pipe ShellUtils::toUpperMember } // HELLO WORLD
}

