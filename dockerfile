FROM openjdk:17-oracle
COPY ./target/library-authentication-service-0.0.1-SNAPSHOT.jar library-authentication-service.jar
CMD ["java","-jar","library-authentication-service.jar"]