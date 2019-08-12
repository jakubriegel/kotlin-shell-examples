#!/usr/bin/env bash

CODEGEN_JAR=swagger-codegen-cli.jar

GROUP_ID=io.example
PACKAGE_NAME=${GROUP_ID}.kotlinshellextension.example
ARTIFACT=generated-client-bash

DEF_URL=petstore.swagger.io/v2/swagger.json

PROJECT_DIR=${ARTIFACT}
if [[ ! -d ${PROJECT_DIR} ]]; then
    mkdir ${PROJECT_DIR}
fi

if [[ ! -f ${PROJECT_DIR}/${CODEGEN_JAR} ]]; then
    wget http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.4/swagger-codegen-cli-2.4.4.jar \
        -O ${PROJECT_DIR}/${CODEGEN_JAR}
fi

java -jar ${PROJECT_DIR}/${CODEGEN_JAR} generate -i http://${1:-${DEF_URL}} \
    --api-package ${PACKAGE_NAME}.api \
    --model-package ${PACKAGE_NAME}.api.model \
    --invoker-package ${PACKAGE_NAME}.app \
    --group-id ${GROUP_ID} \
    --artifact-id ${ARTIFACT} \
    --artifact-version 0.0.1 \
    -l java \
    --library resttemplate \
    -o ${PROJECT_DIR}
