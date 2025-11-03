package in.co.practice.ms.apigw.filters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
class RequestFilterTest {

    @Mock
    private ServerWebExchange exchange;

    @Mock
    private GatewayFilterChain chain;

    @InjectMocks
    private RequestFilter requestFilter;

    @Test
    void testFilterCallsChain() {
        when(chain.filter(exchange)).thenReturn(Mono.empty());

        Mono<Void> result = requestFilter.filter(exchange, chain);

        assertNotNull(result);
        verify(chain).filter(exchange);
    }
}