# Use the official OpenJDK 11 as the base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copy the application source code to the container
COPY . /app

# Build the Java application using Maven
RUN mvn clean package

# Set the entry point for running the application
CMD ["sh", "-c", "cd target && set -a && eval \"java -jar your-java-app.jar\" && set +a && env"]
