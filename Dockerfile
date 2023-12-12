FROM openjdk:11
EXPOSE 8082
ARG JAR_FILE=target/eventsProject-1.0.0.jar
COPY /target/eventsProject-1.0.0.jar eventsProject-1.0.0.jar

ENTRYPOINT ["java","-jar","eventsProject-1.0.0.jar"]