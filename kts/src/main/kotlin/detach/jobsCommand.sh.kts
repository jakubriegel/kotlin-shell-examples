#!/usr/bin/env kshell

package detach

val echo = "echo hello".process()

shell {
    detach(echo.copy(), echo.copy(), echo.copy())
    detach { echo.copy() pipe "cat".process() }

    // call the command
    jobs()
    // [1] [[SystemProcess 1] PID echo]
    // [2] [[SystemProcess 2] PID echo]
    // [3] [[SystemProcess 3] PID echo]
    // [4] [Pipeline ID]

    // pipe the command
    pipeline { jobs pipe "grep Pipeline".process() }
    // [4] [Pipeline ID]
}
