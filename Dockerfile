FROM openjdk:11
EXPOSE 8082
ARG JAR_FILE=target/eventsProject-1.0.0.jar
COPY target/eventsProject.jar eventsProject.jar
ENTRYPOINT ["java","-jar","eventsProject-1.0.0.jar"]