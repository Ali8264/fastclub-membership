package com.fastclub.membership.adapter;

import org.springframework.stereotype.Component;

@Component
public class MockBillingAdapter implements BillingAdapter {

    @Override
    public boolean charge(String userId, double amount) {
        // Mock billing always succeeds
        return true;
    }
}
