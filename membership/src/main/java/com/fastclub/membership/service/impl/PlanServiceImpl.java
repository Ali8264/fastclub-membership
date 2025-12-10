package com.fastclub.membership.service.impl;

import com.fastclub.membership.domain.Plan;
import com.fastclub.membership.domain.Tier;
import com.fastclub.membership.repository.PlanRepository;
import com.fastclub.membership.repository.TierRepository;
import com.fastclub.membership.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;
    private final TierRepository tierRepository;

    public PlanServiceImpl(PlanRepository planRepository, TierRepository tierRepository) {
        this.planRepository = planRepository;
        this.tierRepository = tierRepository;
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public List<Tier> getAllTiers() {
        return tierRepository.findAll();
    }
}
