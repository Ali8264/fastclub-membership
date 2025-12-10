package com.fastclub.membership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tier {

    @Id
    private String id; // 1, 2, 3

    private String name; // SILVER, GOLD, PLATINUM

    private Integer discountPercent;
    private Boolean freeDelivery;
    private Boolean prioritySupport;
}
