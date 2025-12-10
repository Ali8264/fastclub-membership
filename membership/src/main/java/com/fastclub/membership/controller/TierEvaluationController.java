package com.fastclub.membership.controller;

import com.fastclub.membership.dto.TierEvaluationRequest;
import com.fastclub.membership.service.TierEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/memberships")
public class TierEvaluationController {

    private final TierEvaluationService tierEvaluationService;

    public TierEvaluationController(TierEvaluationService tierEvaluationService) {
        this.tierEvaluationService = tierEvaluationService;
    }

    @PostMapping("/evaluate-tier")
    public String evaluateTier(@RequestBody TierEvaluationRequest request) {
        return tierEvaluationService.evaluateTier(
                request.getUserId(),
                request.getTotalOrders(),
                request.getTotalSpend()
        );
    }
}
