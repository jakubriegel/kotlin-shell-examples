# Kotlin Shell Examples
This repository provides examples on using [Kotlin Shell](https://github.com/jakubriegel/kotlin-shell) library

The examples can be run both via command line and Intellij IDEA.

All examples from `kotlin` can be executes as scripts and all examples from `kts` can be executed as part of Kotlin code. 

> As scripting support in Intellij IDEA is still under development, examples may not run properly on every versions. 
> Despite the highlighting and completion should work fine.

## run it with command line
### kotlin

type:
```shell
./gradlew -Psample=[RELATIVE-CLASS-PATH] -Plogs=true execute [--args="ARGS"]
```

example:
```shell
$ cd kotlin
$ ./gradlew -Psample=basic.HelloKt execute
hello world!
```

To see logs add `-Plogs=true` parameter.

### kts
To run scripts you need [kshell](https://github.com/jakubriegel/kshell) installed

type:
```shell
cd kts
kshell src/kotlin/[PATH-TO-SAMPLE] [ARGS]
```

example:
```shell
$ cd kts
$ kshell src/kotlin/basic/hello.sh.kts
hello world!
```

## run it with Intellij IDEA
### kotlin
After importing Gradle project you will be able to run `main()` functions in sample classes.

### kts
After importing Gradle project you will be able to run script files.

### file template
File `kts/fileTemplate_sh_kts` contains template definition for Intellij. 
To use it put this file in `~/Library/Preferences/IntelliJIdea/fileTemplates` with name `KotlinShell.sh.kts`.

## logging
Kotlin Shell features `slf4j` logging interface. 
All examples use NOP logger by default. Configurations for loggers can be found under `resources/log4j2.xml`.

### kotlin
By default Gradle project imports NOP logger. To change it use these [instructions](#run-it-with-command-line).

### kts
Both `kshell` and Gradle uses NOP logger by default. You can change this dependency manually to see the logs.

## side by side examples
In `sidebyside` package there are located side by side examples of scripts written with Kotlin Shell and Bash. 
They are always equal in terms of evaluation.
