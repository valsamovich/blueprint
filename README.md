# spring-boot-restful-web-service [![Build Status](https://travis-ci.org/vsamov/spring-boot-restful-web-service.svg?branch=master)](https://travis-ci.org/vsamov/spring-boot-restful-web-service) [![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)](LICENSE)

RESTful Web Service with Spring Boot and JAX-RS 

## Requirements

- Java `1.8`
  - Port `8080`
  - Lombock
- Maven `3.3.3`

## Run

To run application from **Integrated Development Environment** (IDE):

- Build the application through your IDE
  - For **IntelliJ IDEA Lombok** plugin must be installed
- Run [`com.tools.service.dataconsistency.App`](/src/main/java/com/tools/service/dataconsistency/App.java) as a Java Application

To run application from **Command-Line Interface** (CLI):

- Build the application through your CLI: `mvn clean package`
- Run application as a `java -jar target/webservice_dataconsistency-*.jar`

When service is up, visit http://localhost:8080/greeting to see:

    {
        "Spring Boot": "v1.3.5.RELEASE"
    }

## Docker

Application support docker and deployed via [Dockerfile](Dockerfile):
    
    FROM java:openjdk-8-jre
    VOLUME /tmp
    ARG APP_VERSION
    ADD

