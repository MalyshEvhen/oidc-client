package ua.malysh.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private static final String PRODUCTS_URI = "http://localhost:8082/api/v1/products";

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(rs -> rs
                        .path("/products")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri(PRODUCTS_URI))
                .build();
    }
}
