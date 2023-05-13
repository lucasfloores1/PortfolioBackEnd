FROM amazoncorretto:17

MAINTAINER lucas_flores

COPY target/PortfolioBackEnd-0.0.1-SNAPSHOT.jar PortfolioBackEnd-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/PortfolioBackEnd-0.0.1-SNAPSHOT.jar"]