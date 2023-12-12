FROM openjdk:11
ARG NEXUS_URL=http://192.168.33.10:8082/repository/maven-snapshots/tn/esprit/eventsProject/1.0.0-SNAPSHOT/
ARG JAR_FILE=eventsProject-1.0.0-20231211.184858-1.jar
ADD ${NEXUS_URL}${JAR_FILE} eventsProject-1.0.0.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","/eventsProject-1.0.0.jar"]