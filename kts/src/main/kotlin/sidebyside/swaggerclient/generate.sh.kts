#!/usr/bin/env kshell

package swaggerclient

val codegenJar = "swagger-codegen-cli.jar"

val groupId = "io.example"
val packageName = "$groupId.kotlinshellextension.example"
val artifactId = "generated-client-kts"

val swaggerUrl = args.firstOrNull() ?: "petstore.swagger.io/v2/swagger.json"

shell {

    runCatching { mkdir(artifactId) }
    cd(artifactId)

    file(codegenJar).let {
        if (it.length() == 0.toLong()) {
            val url = "http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.4/swagger-codegen-cli-2.4.4.jar"
            "wget $url -O $codegenJar"()
        }
    }

    val generate = systemProcess {
        cmd {
            "java" withArgs listOf(
                    "-jar", codegenJar, "generate",
                    "-i", "http://$swaggerUrl",
                    "--api-package", "$packageName.api",
                    "--model-package", "$packageName.api.model",
                    "--invoker-package", "$packageName.app",
                    "--group-id", groupId,
                    "--artifact-id", artifactId,
                    "--artifact-version", "0.0.1",
                    "-l", "java",
                    "--library", "resttemplate",
                    "-o", artifactId
            )
        }
    }

    generate()
}
