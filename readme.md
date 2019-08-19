# Kotlin Shell Examples
This repository provides examples on using [Kotlin Shell](https://github.com/jakubriegel/kotlin-shell) library

The examples can be run both via command line and Intellij IDEA

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
kshell src/eu/jrie/jetbrains/kotlinshell/examples/kts/[PATH-TO-SAMPLE] [ARGS]
```

example:
```shell
$ cd kts
$ kshell src/eu/jrie/jetbrains/kotlinshell/examples/kts/basic/hello.sh.kts
hello world!
```

## run it with Intellij IDEA
### kotlin
After importing Gradle project you will be able to run `main()` functions in sample classes.

### kts
After importing Gradle project you will be able to run script files.

## logging
Kotlin Shell features `slf4j` logging interface. 
All examples use NOP logger by default. Configurations for loggers can be found under `resources/log4j2.xml`.

### kotlin
By default Gradle project imports NOP logger. To change it use these [instructions](#run-it-with-command-line).

### kts
Both `kshell` and Gradle uses NOP logger by default. You can change this dependency manually to see the logs.
