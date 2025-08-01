package com.example.sbernotify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/ping")
    public String ping() {
        return "API Gateway is running";
    }
}