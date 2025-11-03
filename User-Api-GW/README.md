# User API Gateway

A Spring Cloud Gateway microservice that acts as a single entry point for user-related operations.

## Overview

This API Gateway routes requests to different user microservices based on HTTP methods and paths:

- **POST /employees** → User Registration Service (port 9093)
- **GET /employees** → User All Records Service (port 9092) 
- **GET /employees/{id}** → User Single Record Service (port 9091)

## Technology Stack

- Java 17
- Spring Boot 3.2.0
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka Client
- Maven

## Configuration

### Application Properties
- **Port**: 8080
- **Eureka**: Configurable via `EUREKA_URL` environment variable
- **Health Checks**: Available at `/actuator/health`

### Routes
All routes are configured in `ApiGatewayConfig.java` with appropriate filters applied.

## Running the Application

### Local Development
```bash
mvn clean package
java -jar target/User-Api-GW-0.0.1-SNAPSHOT.jar
```

### Docker
```bash
docker build -t user-api-gw .
docker run -p 8080:8080 user-api-gw
```

### Docker Compose
```bash
docker-compose up
```

## Health Check
```bash
curl http://localhost:8080/actuator/health
```

## Architecture

The gateway implements reactive programming patterns using Spring WebFlux and provides:
- Request routing based on path and HTTP method
- Request filtering for monitoring and preprocessing
- Service discovery integration with Eureka
- Health monitoring via Spring Actuator