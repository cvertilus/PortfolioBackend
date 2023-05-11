FROM amazoncorretto:17-alpine-jdk

COPY target/Porfolio_Backend.jar Porfolio_Backend.jar

ENTRYPOINT ["java","-jar","/Porfolio_Backend.jar"]