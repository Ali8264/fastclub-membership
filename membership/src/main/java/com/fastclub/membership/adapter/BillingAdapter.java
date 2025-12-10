package com.fastclub.membership.adapter;

public interface BillingAdapter {
    boolean charge(String userId, double amount);
}
