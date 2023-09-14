package com.VMABB.controller;

import com.VMABB.calculator.PremiumCalculator;
import com.VMABB.model.PremiumCalculationResponse;
import com.VMABB.model.Proposal; // Import the Proposal model
import com.VMABB.service.ProposalService; // Import the ProposalService

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
    private final ProposalService proposalService;

    @Autowired
    public NewProposalController(PremiumCalculator premiumCalculator, ProposalService proposalService) {
        this.premiumCalculator = premiumCalculator;
        this.proposalService = proposalService; // Inject the ProposalService
    }

    @GetMapping("/new-proposal")
    public String showNewProposalPage() {
        return "newproposal";
    }

    @PostMapping("/calculate-premium")
    @ResponseBody
    public PremiumCalculationResponse calculatePremium(
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

        // Create a new Proposal instance and set the proposal data
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
        proposal.setPremium(premium); // Set the premium value

        // Save the Proposal entity to the database using your ProposalService
        proposalService.saveProposal(proposal);

        return new PremiumCalculationResponse(premium);
    }
}
