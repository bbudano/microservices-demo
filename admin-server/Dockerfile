FROM openjdk:17-oracle
COPY ./target/admin-server-*.jar service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service.jar"]