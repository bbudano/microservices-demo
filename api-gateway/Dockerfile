FROM openjdk:11-jre
COPY ./build/libs/api-gateway-*.jar service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service.jar"]