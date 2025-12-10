package com.fastclub.membership.service.impl;

import com.fastclub.membership.domain.Subscription;
import com.fastclub.membership.repository.SubscriptionRepository;
import com.fastclub.membership.service.TierEvaluationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TierEvaluationServiceImpl implements TierEvaluationService {

    private final SubscriptionRepository subscriptionRepository;

    public TierEvaluationServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    @Transactional
    public String evaluateTier(String userId, int totalOrders, double totalSpend) {

        Subscription subscription = subscriptionRepository
                .findByUserIdAndStatus(userId, "ACTIVE")
                .orElseThrow(() -> new RuntimeException("No active subscription found"));

        String newTier = calculateTier(totalOrders, totalSpend);

        subscription.setTierId(newTier);
        subscriptionRepository.save(subscription);

        return newTier;
    }

    private String calculateTier(int orders, double spend) {

        if (orders >= 10 || spend >= 5000) {
            return "3"; // PLATINUM
        } else if (orders >= 5 || spend >= 2000) {
            return "2"; // GOLD
        } else {
            return "1"; // SILVER
        }
    }
}
