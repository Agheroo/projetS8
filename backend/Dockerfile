FROM eclipse-temurin:17-jdk-alpine
RUN adduser -D eclipse-temurin
WORKDIR /home/eclipse-temurin/backend
COPY . .
RUN ./mvnw package -DskipTests
USER eclipse-temurin
EXPOSE 8080
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]