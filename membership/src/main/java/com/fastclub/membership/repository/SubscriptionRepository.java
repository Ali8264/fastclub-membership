package com.fastclub.membership.repository;

import com.fastclub.membership.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
    Optional<Subscription> findByUserIdAndStatus(String userId, String status);
}
