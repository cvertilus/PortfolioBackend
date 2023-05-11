FROM amazoncorretto:17

COPY out/artifacts/PortfolioBackend_jar/PortfolioBackend.jar Portfolio_Backend.jar

ENTRYPOINT ["java","-jar","/Portfolio_Backend.jar"]