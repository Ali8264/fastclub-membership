package com.fastclub.membership.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
      @GetMapping("/health")
    public String healthCheck() {
        return "Membership Service is Running!";
    }
}
