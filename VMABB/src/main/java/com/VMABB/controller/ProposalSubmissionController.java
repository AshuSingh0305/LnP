package com.VMABB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.VMABB.calculator.PremiumCalculator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.VMABB.model.Proposal;
import com.VMABB.service.ProposalService;

@Controller
public class ProposalSubmissionController {

	private final PremiumCalculator premiumCalculator;
    private final ProposalService proposalService;

    @Autowired
    public ProposalSubmissionController(PremiumCalculator premiumCalculator, ProposalService proposalService) {
        this.premiumCalculator = premiumCalculator;
        this.proposalService = proposalService;
    }

    @PostMapping("/submit-proposal")
    public String submitProposal(
    		@RequestParam String proposalName,
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
        // Calculate premium
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

        // Create a new Proposal
        Proposal proposal = new Proposal();
        proposal.setProposalName(proposalName);
        proposal.setAge(age);
        proposal.setIsSmoker(isSmoker);
        proposal.setLifeCoverAmount(lifeCoverAmount);
        proposal.setAnnualIncome(annualIncome);
        proposal.setAccidentDeathBenefit(accidentDeathBenefit);
        proposal.setAccidentDeathCoverage(accidentDeathCoverage);
        proposal.setComprehensiveCare(comprehensiveCare);
        proposal.setComprehensiveCareCoverage(comprehensiveCareCoverage);
        proposal.setPaymentTenure(PaymentTenure);
        proposal.setCity(city);
        proposal.setQualification(qualification);
        proposal.setOccupation(occupation);
        proposal.setPaymentMode(paymentMode);
        proposal.setPremium(premium); // Set the premium calculated

        // Save the Proposal to the database
        proposalService.saveProposal(proposal);

        return "proposal_confirmation"; // Redirect to a confirmation page
    }
}

