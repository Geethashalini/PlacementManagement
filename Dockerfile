# ---------- Build Stage ----------
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy PMS project
COPY PMS/ .

# Build jar
RUN mvn clean package -DskipTests

# ---------- Run Stage ----------
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Spring Boot port
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
