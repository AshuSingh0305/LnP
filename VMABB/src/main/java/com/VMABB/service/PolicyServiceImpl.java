package com.VMABB.service;

 

//<<<<<<< Updated upstream

// Add other methods for policy-related operations here

//=======

import java.util.ArrayList;

import java.util.List;

 

import org.springframework.stereotype.Service;

 

import com.VMABB.exception.PolicyNotFoundException;

import com.VMABB.model.Policy;

 

@Service

public class PolicyServiceImpl implements PolicyService {

	

	//private final List<Policy> policies = new ArrayList<>();

 

 

 

    @Override

    public List<Policy> getAllPolicies() {

        return policies;

    }

	

	private final List<Policy> policies = new ArrayList<>();

	private int lastGeneratedPolicyId = 7366;

	

	public PolicyServiceImpl() {

		policies.add(new Policy(1, "Term Insurance", "John Doe"));

		policies.add(new Policy(1,"Gloria","Term Insurance","pending",0));

		policies.add(new Policy(2,"Jay","Term Insurance","approved",7123));

		policies.add(new Policy(3,"Manny","Term Insurance","rejected",7364));

		

	}

	

	@Override

	public List<Policy> getPendingPolicies() {

	    List<Policy> pendingPolicies = new ArrayList<>();

	    for (Policy policy : policies) {

	        if ("pending".equalsIgnoreCase(policy.getStatus())) {

	            pendingPolicies.add(policy);

	        }

	    }

	    return pendingPolicies;

	}

 

	@Override

	public List<Policy> getApprovedPolicies() {

	    List<Policy> approvedPolicies = new ArrayList<>();

	    for (Policy policy : policies) {

	        if ("approved".equalsIgnoreCase(policy.getStatus())) {

	            approvedPolicies.add(policy);

	        }

	    }

	    return approvedPolicies;

	}

	

	@Override

	public List<Policy> getRejectedPolicies() {

	    List<Policy> rejectedPolicies = new ArrayList<>();

	    for (Policy policy : policies) {

	        if ("rejected".equalsIgnoreCase(policy.getStatus())) {

	            rejectedPolicies.add(policy);

	        }

	    }

	    return rejectedPolicies;

	}

 

	@Override

    public Policy updatePolicyStatus(Long proposalId, String status) {

        // Find the policy with the given proposalId and update its status

        for (Policy policy : policies) {

            if (policy.getProposalId() == proposalId) {

                policy.setStatus(status);

 

                // Generate a 4-digit policy ID if the status is "approved"

                if ("approved".equalsIgnoreCase(status)) {

                    // Increment the lastGeneratedPolicyId

                    lastGeneratedPolicyId++;

                    // Set the generated policy ID

                    policy.setPolicyId(lastGeneratedPolicyId);

                }

 

                return policy; // Return the updated policy

            }

        }

        throw new PolicyNotFoundException("Policy not found for proposalId");

	}

 

 

}

 