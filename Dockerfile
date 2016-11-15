FROM java:openjdk-8-jre
VOLUME /tmp
ADD target/spring-boot-skeleton-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
