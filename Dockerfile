FROM ubuntu:latest AS build
 
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
 
RUN apt-get install maven -y
RUN mvn clean install -DskipTests
 
FROM openjdk:17-jdk-slim
 
EXPOSE 8080

COPY --from=build /target/Rehab-0.0.1-SNAPSHOT.jar appRehad.jar

ENTRYPOINT [ "java", "-jar", "appRehad.jar" ]