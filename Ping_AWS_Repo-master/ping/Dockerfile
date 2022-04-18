FROM alpine:3.13

RUN apk add openjdk11
COPY target/ping-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]