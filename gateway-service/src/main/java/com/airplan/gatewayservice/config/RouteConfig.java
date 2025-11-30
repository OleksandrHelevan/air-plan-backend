package com.airplan.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("plane-service", predicate ->
                        predicate.path("/planes/**", "/airlines/**")
                                .uri("lb://plane-service")
                )
                .route("flight-service", predicate ->
                        predicate.path("/flights/**")
                                .uri("lb://flight-service")
                )
                .build();
    }
}