FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ARG APP_VERSION
ADD spring-boot-restful-web-serivce-${APP_VERSION}.jar app.jar
ADD ${APP_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.historyegd=file:/dev/./urandom","-jar","/app.jar"]
