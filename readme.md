# Kotlin Shell Examples
This repository provides examples on using [Kotlin Shell](https://github.com/jakubriegel/kotlin-shell) library

The examples can be run both via command line and Intellij IDEA

## run it with command line
### kotlin

type:
```shell
cd kotlin
./gradlew -PsampleClass=[RELATIVE-CLASS-PATH] execute [--args="ARGS"]
```

example:
```shell
$ cd kotlin
$ ./gradlew -PsampleClass=basic.HelloKt execute
hello world!
```


### kts
To run scripts you first need [kshell](https://github.com/jakubriegel/kshell) installed

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
Import Gradle project and you will be able to run selected functions

### kts
You need to manually add `kotlin-shell-kts` dependencies to Intellij. You can find the full list under `kts/lib/kotlin-shell-kts-dependencies`.
Then you will be able to run the scripts

## logging
Kotlin Shell features `slf4j` logging interface

### kotlin
By default Gradle project import NOP logger. You can change this dependency to see logs.

### kts
'kshell' uses NOP logger. 

In Intellij you can see logs after providing logger implementation and changing settings under `kts/resources/log4j2.xml`. By default all logs are turned off.
