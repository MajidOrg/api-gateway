package com.res.mapigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/restaurantFallback")
    public ResponseEntity<String> restaurantFallBack(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing an issue with your order. We shall call you back in 5 minutes");
    }
}
