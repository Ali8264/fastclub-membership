package com.fastclub.membership.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId;

    private String planId;

    private String tierId;

    private LocalDateTime startDate;

    private LocalDateTime expiryDate;

    private String status;  // ACTIVE, CANCELLED, EXPIRED

    @Version
    private Integer version;
}
