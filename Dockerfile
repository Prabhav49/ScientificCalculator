# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the correct JAR file to the container
COPY target/ScientificCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Allow both interactive input and arguments
ENTRYPOINT ["java", "-jar", "app.jar"]
CMD []
