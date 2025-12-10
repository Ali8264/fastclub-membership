package com.fastclub.membership.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscribeRequest {
    private String userId;
    private String planId;
    private String tierId;
}
