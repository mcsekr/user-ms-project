FROM eclipse-temurin:17-jre

WORKDIR /app
COPY target/user-registration-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9093

ENTRYPOINT ["java", "-jar", "app.jar"]