# Use Maven with OpenJDK 17 for building the app
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and fetch dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the code
COPY . .

# Build the app
RUN mvn clean package -DskipTests

# Use OpenJDK 17 image for the final app container
FROM openjdk:17

# Set working directory inside container
WORKDIR /app

# Copy the packaged jar file from the build image
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 for the app
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "app.jar"]
