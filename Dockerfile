# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
ENV SPRING_DATA_MONGODB_PORT=27017
ENV SPRING_DATA_MONGODB_HOST=172.17.0.2
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
ENV SPRING_DATA_MONGODB_PORT=27017
ENV SPRING_DATA_MONGODB_HOST=172.17.0.2
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
