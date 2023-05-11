FROM amazoncorretto:17-alpine-jdk

COPY target/Portfolio_Backend-0.0.1-SNAPSHOT.jar Portfolio_Backend.jar

ENTRYPOINT ["java","-jar","/Portfolio_Backend.jar"]