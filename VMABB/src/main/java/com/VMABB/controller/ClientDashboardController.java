//Controls actions related to the client dashboard

package com.VMABB.controller;

import com.VMABB.model.Policy;
import com.VMABB.service.PolicyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/client-dashboard")
public class ClientDashboardController {

    private final PolicyService policyService;

    public ClientDashboardController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/view")
    public String viewDashboard(Model model) {
        List<Policy> policies = policyService.getAllPolicies();

        // Add the list of policies to the model
        model.addAttribute("policies", policies);

        return "client_dashboard"; // This should match your HTML template name
    }
//    @GetMapping("/new-proposal")
//    public String viewNewProposalForm(Model model) {
//        // Add logic to populate the model with data needed for the new proposal form
//        return "new_proposal"; // This should match your HTML template name
//    }

    @GetMapping("/policy-list")
    public String viewPolicyList(Model model) {
        // Add logic to populate the model with data needed for the policy list view
        return "policy_list"; // This should match your HTML template name
    }

    @GetMapping("/policy-details")
    public String viewPolicyDetails(@RequestParam("policyId") Long policyId, Model model) {
        // Add logic to fetch and populate the model with policy details based on the policyId
        return "policy_details"; // This should match your HTML template name
    }

    // Add more mappings for other actions as needed
}

