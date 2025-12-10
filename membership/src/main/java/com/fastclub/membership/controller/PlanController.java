package com.fastclub.membership.controller;

import com.fastclub.membership.domain.Plan;
import com.fastclub.membership.domain.Tier;
import com.fastclub.membership.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/memberships")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/plans")
    public List<Plan> getPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("/tiers")
    public List<Tier> getTiers() {
        return planService.getAllTiers();
    }
}
