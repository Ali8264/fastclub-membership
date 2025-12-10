package com.fastclub.membership.repository;

import com.fastclub.membership.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
    Optional<Subscription> findByUserIdAndStatus(String userId, String status);
    List<Subscription> findByStatusAndExpiryDateBefore(String status, LocalDateTime now);

}
