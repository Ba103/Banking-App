# Use an official OpenJDK runtime image
FROM openjdk:17

# Set working directory inside the container
WORKDIR /bamking-app

# Copy the built JAR file into the container
COPY target/banking-app-0.0.1-SNAPSHOT.jar /banikg-app/banking-app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "banking-app.jar"]
