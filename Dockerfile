FROM FROM maven:3.3.9-jdk-8-onbuild
ADD target/spring-boot-skeleton-1.0.0.jar /opt/demo/spring-boot-skeleton-1.0.0.jar
CMD ["java","-jar","/opt/demo/spring-boot-skeleton-1.0.0.jar"]
