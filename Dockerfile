FROM amazoncorretto:17-alpine-jdk

COPY out/artifacts/PortfolioBackend_jar/PortfolioBackend.jar Portfolio_Backend.jar

ENTRYPOINT ["java","-jar","/Portfolio_Backend.jar"]