package com.res.mapigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RestaurantGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("******* Inside Global Filter *******");
        var requestWithHeader = exchange.getRequest().mutate()
                .header("restaurant","Mazid Restaurant")
                .build();
        return chain.filter(exchange.mutate().request(requestWithHeader).build());
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
