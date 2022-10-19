package com.res.mapigateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes().build();
    }

    @Bean
    public RouteLocator restaurantRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/res/v2/*")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("order")
                                .setFallbackUri("forward:/fallback/restaurantFallback")))
                        .uri("lb://restaurant-order"))
                .build();
    }


}
