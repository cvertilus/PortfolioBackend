FROM amazoncorretto:17-alpine-jdk

COPY target/Portfolio_Backend.jar Portfolio_Backend.jar

ENTRYPOINT ["java","-jar","/Portfolio_Backend.jar"]