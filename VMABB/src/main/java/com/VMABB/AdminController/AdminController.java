//Handles admin-related actions

package com.VMABB.AdminController;

 

 

import java.util.HashMap;
import java.util.Map;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 

import com.VMABB.model.Policy;
import com.VMABB.service.PolicyService;

 

 

@Controller
//@RequestMapping("/adminDashboard")
public class AdminController {

	@Autowired
    private final PolicyService policyService;

 

    public AdminController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @RequestMapping("/AdminDashboard")
    public String getAdminDashboard(Model model) {
    	return "adminDashboard";
    }

 

    @RequestMapping("/AdminDashboard/pendingPolicies")
    public String getPendingPolicies(Model model) {
        model.addAttribute("pendingPolicies", policyService.getPendingPolicies());
        return "pendingPolicies"; // Return the name of the HTML template for pending policies
    }

    @PostMapping("/AdminDashboard/pendingPolicies/changeStatus/{proposalId}")
    @ResponseBody // Ensure this method returns a JSON response
    public ResponseEntity<Map<String, Object>> changeStatus(
        @PathVariable Long proposalId,
        @RequestParam String status
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            Policy updatedPolicy = policyService.updatePolicyStatus(proposalId, status);
            response.put("success", true);
            response.put("newPolicyId", updatedPolicy.getPolicyId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

 

 

    

    @RequestMapping("/AdminDashboard/approvedPolicies")
    public String getApprovedPolicies(Model model) {
        model.addAttribute("approvedPolicies", policyService.getApprovedPolicies());
        return "approvedPolicies"; // Return the name of the HTML template for approved policies
    }

 

    @RequestMapping("/AdminDashboard/rejectedPolicies")
    public String getRejectedPolicies(Model model) {
        model.addAttribute("rejectedPolicies", policyService.getRejectedPolicies());
        return "rejectedPolicies"; // Return the name of the HTML template for rejected policies
    }

 

}