FROM eclipse-temurin:17-jre

WORKDIR /app
COPY target/user-login-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9094

ENTRYPOINT ["java", "-jar", "app.jar"]