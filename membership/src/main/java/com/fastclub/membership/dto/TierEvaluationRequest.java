package com.fastclub.membership.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierEvaluationRequest {
    private String userId;
    private int totalOrders;
    private double totalSpend;
}
