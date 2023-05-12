FROM amazoncorretto:17-alpine-jdk
MAINTAINER COLBY
COPY target/Portfolio_Backend-0.0.1-SNAPSHOT.jar Portfolio_Backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Portfolio_Backend.jar"]