package com.fastclub.membership.repository;

import com.fastclub.membership.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, String> {
}
