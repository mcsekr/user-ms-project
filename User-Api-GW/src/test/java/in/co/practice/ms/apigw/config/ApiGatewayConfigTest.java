package in.co.practice.ms.apigw.config;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import in.co.practice.ms.apigw.filters.RequestFilter;

@ExtendWith(MockitoExtension.class)
class ApiGatewayConfigTest {

    @Mock
    private RequestFilter requestFilter;

    @Mock
    private RouteLocatorBuilder routeLocatorBuilder;

    @InjectMocks
    private ApiGatewayConfig apiGatewayConfig;

    @Test
    void testCustomRouteLocatorNotNull() {
        RouteLocatorBuilder.Builder mockBuilder = mock(RouteLocatorBuilder.Builder.class);
        when(routeLocatorBuilder.routes()).thenReturn(mockBuilder);
        when(mockBuilder.route(anyString(), any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mock(RouteLocator.class));

        RouteLocator result = apiGatewayConfig.customRouteLocator(routeLocatorBuilder);

        assertNotNull(result);
        verify(routeLocatorBuilder).routes();
    }
}