package com.fastclub.membership.service;

import com.fastclub.membership.domain.Plan;
import com.fastclub.membership.domain.Tier;
import java.util.List;

public interface PlanService {
    List<Plan> getAllPlans();
    List<Tier> getAllTiers();
}
