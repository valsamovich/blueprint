FROM maven:3.3.9-jdk-8-onbuild
CMD ["java","-jar","/usr/src/app/target/spring-boot-skeleton-1.0.0.jar"]
