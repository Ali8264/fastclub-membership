package com.fastclub.membership.service.impl;

import com.fastclub.membership.adapter.BillingAdapter;
import com.fastclub.membership.domain.Plan;
import com.fastclub.membership.domain.Subscription;
import com.fastclub.membership.dto.SubscribeRequest;
import com.fastclub.membership.dto.SubscriptionResponse;
import com.fastclub.membership.repository.PlanRepository;
import com.fastclub.membership.repository.SubscriptionRepository;
import com.fastclub.membership.service.SubscriptionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final PlanRepository planRepository;
    private final BillingAdapter billingAdapter;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   PlanRepository planRepository,
                                   BillingAdapter billingAdapter) {
        this.subscriptionRepository = subscriptionRepository;
        this.planRepository = planRepository;
        this.billingAdapter = billingAdapter;
    }

    @Override
    @Transactional
    public SubscriptionResponse subscribe(SubscribeRequest request) {

        Plan plan = planRepository.findById(request.getPlanId())
                .orElseThrow(() -> new RuntimeException("Invalid planId"));

        boolean charged = billingAdapter.charge(request.getUserId(), plan.getPrice());
        if (!charged) {
            throw new RuntimeException("Payment Failed");
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiry = switch (plan.getBillingCycle()) {
            case "MONTHLY" -> now.plusMonths(1);
            case "QUARTERLY" -> now.plusMonths(3);
            case "YEARLY" -> now.plusYears(1);
            default -> throw new RuntimeException("Invalid billing cycle");
        };

        Subscription subscription = Subscription.builder()
                .userId(request.getUserId())
                .planId(request.getPlanId())
                .tierId(request.getTierId())
                .startDate(now)
                .expiryDate(expiry)
                .status("ACTIVE")
                .build();

        Subscription saved = subscriptionRepository.save(subscription);

        return SubscriptionResponse.builder()
                .subscriptionId(saved.getId())
                .userId(saved.getUserId())
                .planId(saved.getPlanId())
                .tierId(saved.getTierId())
                .status(saved.getStatus())
                .startDate(saved.getStartDate().toString())
                .expiryDate(saved.getExpiryDate().toString())
                .build();
    }

    @Override
public SubscriptionResponse getActiveSubscription(String userId) {
    Subscription subscription = subscriptionRepository
            .findByUserIdAndStatus(userId, "ACTIVE")
            .orElseThrow(() -> new RuntimeException("No active subscription found"));

    return SubscriptionResponse.builder()
            .subscriptionId(subscription.getId())
            .userId(subscription.getUserId())
            .planId(subscription.getPlanId())
            .tierId(subscription.getTierId())
            .status(subscription.getStatus())
            .startDate(subscription.getStartDate().toString())
            .expiryDate(subscription.getExpiryDate().toString())
            .build();
}

}
