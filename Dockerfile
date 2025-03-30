FROM openjdk:17-jdk-slim
WORKDIR /app

COPY target/ScientificCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# comment to remove
ENTRYPOINT ["sh", "-c", "sleep infinity"]
CMD ["java", "-jar", "app.jar"]

