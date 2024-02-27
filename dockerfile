# Use a base image with Java 17 installed
FROM openjdk:17-oracle

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/*.jar app.jar

# Command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]
