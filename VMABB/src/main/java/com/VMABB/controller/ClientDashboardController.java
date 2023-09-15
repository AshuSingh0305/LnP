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

        return "client_dashboard";
    }

    @GetMapping("/policy-list")
    public String viewPolicyList(Model model) {
        return "policy_list"; 
    }

    @GetMapping("/policy-details")
    public String viewPolicyDetails(@RequestParam("policyId") Long policyId, Model model) {
        return "policy_details"; 
    }

}

