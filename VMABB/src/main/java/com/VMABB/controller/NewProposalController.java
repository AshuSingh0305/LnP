package com.VMABB.controller;

import com.VMABB.calculator.PremiumCalculator;
import com.VMABB.model.PremiumCalculationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewProposalController {

	private final PremiumCalculator premiumCalculator;

	@Autowired
	public NewProposalController(PremiumCalculator premiumCalculator) {
		this.premiumCalculator = premiumCalculator;
	}

	@GetMapping("/new-proposal")
	public String showNewProposalPage() {
		return "newproposal";
	}

	@PostMapping("/calculate-premium")
	@ResponseBody
	public PremiumCalculationResponse calculatePremium(
	    @RequestParam int age,
	    @RequestParam boolean isSmoker,
	    @RequestParam double lifeCoverAmount,
	    @RequestParam double annualIncome,
	    @RequestParam(required = false, defaultValue = "false") boolean accidentDeathBenefit,
	    @RequestParam(required = false, defaultValue = "25000") double accidentDeathCoverage,
	    @RequestParam(required = false, defaultValue = "false") boolean comprehensiveCare,
	    @RequestParam(required = false, defaultValue = "200000") double comprehensiveCareCoverage,
	    @RequestParam int PaymentTenure,
	    @RequestParam String city,
	    @RequestParam String qualification,
	    @RequestParam String occupation,
	    @RequestParam String paymentMode,
	    Model model
	) {
	    double premium = premiumCalculator.calculateTermInsurancePremium(
	        age,
	        isSmoker,
	        lifeCoverAmount,
	        annualIncome,
	        accidentDeathBenefit,
	        accidentDeathCoverage,
	        comprehensiveCare,
	        comprehensiveCareCoverage,
	        PaymentTenure,
	        city,
	        qualification,
	        occupation,
	        paymentMode
	    );
	    return new PremiumCalculationResponse(premium);
	}
}
