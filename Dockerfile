# Use Maven with Java 21
FROM maven:3.9.9-eclipse-temurin-21

# Set working directory
WORKDIR /app

# Copy entire project
COPY . .

# Run Maven build + tests
CMD ["mvn", "clean", "test]