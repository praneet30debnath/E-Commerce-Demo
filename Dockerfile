FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk maven -y
COPY . .
RUN mvn clean package

# Use a smaller base image to run the application
FROM openjdk:17-jdk-slim
COPY --from=build /target/ecommerce-1.0.0.jar /app/ecomm-app.jar
ENTRYPOINT ["java", "-jar", "/app/ecomm-app.jar"]
EXPOSE 8084