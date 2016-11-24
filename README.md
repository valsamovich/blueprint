# blueprint [![Build Status](https://travis-ci.org/vsamov/blueprint.svg?branch=master)](https://travis-ci.org/vsamov/blueprint) [![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)](LICENSE) [![Docker Automated buil](https://img.shields.io/docker/automated/jrottenberg/ffmpeg.svg)](https://hub.docker.com/r/vsamov/blueprint/)

Spring Boot CXF Client Application with JAX-RS 

## Installations

- Java `1.8` (Port `8080`, Lombock)
- Maven `3.3.3`

## Usage

To run application from **Integrated Development Environment** (IDE):

- Build the application through your IDE
  - For **IntelliJ IDEA Lombok** plugin must be installed
- Run [`com.samovich.service.blueprint.App`](/src/main/java/com/samovich/service/blueprint/App.java) as a Java Application

To run application from **Command-Line Interface** (CLI):

- Build the application through your CLI: `mvn clean package`
- Run application as a `java -jar target/webservice_dataconsistency-*.jar`

When service is up, visit http://localhost:8080/blueprint to see:

    {
        "Spring Boot": "v1.3.5.RELEASE"
    }

## Docker

Application support docker and deployed via [Dockerfile](Dockerfile):
    
    FROM openjdk-8-jre
    VOLUME /tmp
    ARG APP_VERSION
    ADD blueprint-${APP_VERSION}.jar app.jar
    ADD ${APP_FILE} app.jar
    ENTRYPOINT ["java","-Djava.security.historyegd=file:/dev/./urandom","-jar","/app.jar"]

