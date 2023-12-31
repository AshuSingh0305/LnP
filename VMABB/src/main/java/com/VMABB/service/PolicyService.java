package com.VMABB.service;
import java.util.List;

import com.VMABB.model.Policy;

public interface PolicyService {
	List<Policy> getPendingPolicies();

	 

	List<Policy> getApprovedPolicies();

 

	List<Policy> getRejectedPolicies();

 

	Policy updatePolicyStatus(Long proposalId, String status);
	
    List<Policy> getAllPolicies();



	Policy getPolicyByClientId(int clientId);

   // Policy getPolicyById(int policyId);

   
}
