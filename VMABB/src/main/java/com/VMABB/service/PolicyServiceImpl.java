package com.VMABB.service;


import org.springframework.stereotype.Service;

import com.VMABB.model.Policy;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final List<Policy> policies = new ArrayList<>();

    public PolicyServiceImpl() {
        // Add some sample policies for testing
        policies.add(new Policy(1, "Term Insurance", "John Doe"));
        policies.add(new Policy(2, "Whole Life", "Jane Smith"));
        policies.add(new Policy(3, "Moneyback", "Bob Johnson"));
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policies;
    }

    // Add other methods for policy-related operations here
}
