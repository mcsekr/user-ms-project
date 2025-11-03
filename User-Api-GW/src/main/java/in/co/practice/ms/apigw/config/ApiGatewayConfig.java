package in.co.practice.ms.apigw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import in.co.practice.ms.apigw.filters.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * API Gateway Configuration
 * 
 * Configures routing rules for the User API Gateway.
 * Defines routes to different user microservices based on HTTP methods and paths.
 * 
 * Routes configured:
 * - POST /employees -> user-registration service (port 9093)
 * - GET /employees -> user-all-records service (port 9092) with request filter
 * - GET /employees/* -> user-single-record service (port 9091)
 */
@Configuration
public class ApiGatewayConfig {
	
	@Autowired
	private RequestFilter requestFilter;
	
	/**
	 * Creates custom route locator with predefined routing rules
	 * 
	 * @param builder RouteLocatorBuilder to build routes
	 * @return RouteLocator with configured routes
	 */
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		 return builder.routes()
				 // Route for user registration - POST requests to /employees
				 .route("user-registration", r -> r.path("/employees")
	                 .and().method("POST")
	                 .uri("http://localhost:9093"))
				 // Route for fetching all users - GET requests to /employees with filter
				 .route("user-all-records", r1 -> r1.path("/employees")
						 .and().method("GET")
						 .filters(f -> f.filter(requestFilter))
		                 .uri("http://localhost:9092"))
				 // Route for fetching single user - GET requests to /employees/{id}
				 .route("user-single-record", r2 -> r2.path("/employees/*")
						 .and().method("GET")
		                 .uri("http://localhost:9091"))
				 .build();
	}

}
