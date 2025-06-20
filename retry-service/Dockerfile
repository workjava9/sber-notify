FROM eclipse-temurin:17-jdk as builder
WORKDIR /app
COPY ../../../AppData/Local/Temp/Rar$DRa1336.7845.rartemp/retry-service .
RUN ./gradlew clean build -x test
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
