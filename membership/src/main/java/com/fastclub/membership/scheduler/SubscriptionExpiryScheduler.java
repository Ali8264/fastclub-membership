package com.fastclub.membership.scheduler;

import com.fastclub.membership.domain.Subscription;
import com.fastclub.membership.repository.SubscriptionRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SubscriptionExpiryScheduler {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionExpiryScheduler(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?")  // runs every day at midnight
    public void expireSubscriptions() {
        LocalDateTime now = LocalDateTime.now();

        List<Subscription> expired = subscriptionRepository
                .findByStatusAndExpiryDateBefore("ACTIVE", now);

        for (Subscription subscription : expired) {
            subscription.setStatus("EXPIRED");
        }

        subscriptionRepository.saveAll(expired);

        System.out.println("Expired subscriptions count: " + expired.size());
    }
}
