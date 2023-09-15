package com.VMABB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.VMABB.service.PolicyService;
import com.VMABB.model.Policy;

@Controller
public class PolicyDashboardController {
    @Autowired
    private final PolicyService policyService;

    public PolicyDashboardController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/policydashboard/{clientId}")
    public String getClientDetails(@PathVariable int clientId, Model model) {
        Policy clientPolicy = policyService.getPolicyByClientId(clientId);
        if (clientPolicy != null) {
            model.addAttribute("clientPolicy", clientPolicy);
        }
        return "policydashboard";
    }
    
    

        @PostMapping("/cancelPolicy/{clientId}")
        public String cancelPolicy(@PathVariable int clientId) {
            Policy clientPolicy = policyService.getPolicyByClientId(clientId);
            if (clientPolicy != null) {
                // Update the policy status to "cancelled"
                clientPolicy.setStatus("cancelled");
            }
            return "redirect:/policydashboard/" + clientId;
        }
        
        @GetMapping("/policyupdate/{clientId}")
        public String getPolicyUpdatePage(@PathVariable int clientId, Model model) {
            Policy clientPolicy = policyService.getPolicyByClientId(clientId);
            if (clientPolicy != null) {
                model.addAttribute("clientPolicy", clientPolicy);
                return "policyupdate";
            } else {
                return "redirect:/policydashboard"; // Redirect to dashboard if the client does not exist
            }
        }

        @PostMapping("/updatePolicy/{clientId}")
        public String updatePolicy(
        	    @PathVariable int clientId,
        	    @RequestParam String field,  // Added field parameter for selecting the field to update
        	    @RequestParam String value   // Added value parameter for the new value
        	) {
        	    Policy clientPolicy = policyService.getPolicyByClientId(clientId);
        	    if (clientPolicy != null) {
        	        // Update the selected field based on user input
        	        switch (field) {
        	            case "policyType":
        	                clientPolicy.setPolicyType(value);
        	                break;
        	            case "status":
        	                clientPolicy.setStatus(value);
        	                break;
        	            // Add more cases for other fields if needed
        	        }
        	    }
        	    return "redirect:/policydashboard/" + clientId;
        	}
    }