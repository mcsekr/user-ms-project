package in.co.practice.ms.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * User API Gateway Application
 * 
 * This is the main entry point for the User API Gateway microservice.
 * It acts as a single entry point for all user-related microservices,
 * providing routing, filtering, and load balancing capabilities.
 * 
 * @author Practice Team
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApiGwApplication {

	/**
	 * Main method to start the Spring Boot application
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserApiGwApplication.class, args);
	}

}
