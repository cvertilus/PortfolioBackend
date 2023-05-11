FROM amazoncorretto:17-alpine-jdk

COPY target/PortfolioBackend.jar Portfolio_Backend.jar

ENTRYPOINT ["java","-jar","/Portfolio_Backend.jar"]