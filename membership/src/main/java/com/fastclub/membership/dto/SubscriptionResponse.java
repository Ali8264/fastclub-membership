package com.fastclub.membership.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubscriptionResponse {
    private String subscriptionId;
    private String userId;
    private String planId;
    private String tierId;
    private String status;
    private String startDate;
    private String expiryDate;
}
