FROM maven:3.8-openjdk-17 AS build

WORKDIR /app
COPY pom.xml .
COPY settings.xml .
COPY src ./src

RUN mvn clean package -DskipTests -s settings.xml -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.retryHandler.count=3

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app/target/user-registration-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]