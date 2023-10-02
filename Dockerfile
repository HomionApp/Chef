FROM openjdk:17-jdk-slim

MAINTAINER harsh

COPY target/chef-0.0.1-SNAPSHOT.jar chef-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "chef-0.0.1-SNAPSHOT.jar"]