FROM openjdk:11
EXPOSE 8082
ARG JAR_FILE=target/eventsProject-1.0.0.jar
WORKDIR /opt
COPY target/eventsProject-1.0.0.jar  /opt/eventsProject-1.0.0.jar
ENTRYPOINT ["java","-jar","eventsProject-1.0.0.jar"]