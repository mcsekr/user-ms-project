package in.co.practice.ms.apigw.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * Request Filter for API Gateway
 * 
 * This filter intercepts incoming requests and performs pre-processing
 * before forwarding them to downstream services.
 * Currently logs request information for monitoring purposes.
 * 
 * Applied to specific routes as configured in ApiGatewayConfig.
 */
@Component
public class RequestFilter implements GatewayFilter {

	/**
	 * Filters incoming requests before forwarding to downstream services
	 * 
	 * @param exchange ServerWebExchange containing request/response
	 * @param chain GatewayFilterChain to continue processing
	 * @return Mono<Void> representing completion of filter processing
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// Log request for monitoring (should use proper logging in production)
		System.out.println("Inside API GW Request filter");
		return chain.filter(exchange);
	}

}
