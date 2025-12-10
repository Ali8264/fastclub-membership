package com.fastclub.membership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan {

    @Id
    private String id;  // p-monthly, p-quarterly, p-yearly

    private String name;          // Monthly, Quarterly, Yearly
    private String billingCycle;  // MONTHLY, QUARTERLY, YEARLY
    private Double price;         // 199.0, 549.0, 1999.0
}
