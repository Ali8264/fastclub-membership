package com.fastclub.membership.service;

public interface TierEvaluationService {
    String evaluateTier(String userId, int totalOrders, double totalSpend);
}
