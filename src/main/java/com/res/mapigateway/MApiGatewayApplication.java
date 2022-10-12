package com.res.mapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MApiGatewayApplication.class, args);
    }

}
