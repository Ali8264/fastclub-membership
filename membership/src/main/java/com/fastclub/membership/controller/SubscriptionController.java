package com.fastclub.membership.controller;

import com.fastclub.membership.dto.SubscribeRequest;
import com.fastclub.membership.dto.SubscriptionResponse;
import com.fastclub.membership.service.SubscriptionService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/memberships")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscribe")
    public SubscriptionResponse subscribe(@RequestBody SubscribeRequest request) {
        return subscriptionService.subscribe(request);
    }

    @GetMapping("/users/{userId}")
public SubscriptionResponse getActiveSubscription(@PathVariable String userId) {
    return subscriptionService.getActiveSubscription(userId);
}

}
