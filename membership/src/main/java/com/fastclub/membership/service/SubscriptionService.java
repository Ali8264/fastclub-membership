package com.fastclub.membership.service;

import com.fastclub.membership.dto.SubscribeRequest;
import com.fastclub.membership.dto.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse subscribe(SubscribeRequest request);
    SubscriptionResponse getActiveSubscription(String userId);
}
