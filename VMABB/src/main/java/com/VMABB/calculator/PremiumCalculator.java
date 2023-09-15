package com.VMABB.calculator;

import org.springframework.stereotype.Component;

@Component
public class PremiumCalculator {

	public double calculateTermInsurancePremium(int age, boolean isSmoker, double coverageAmount, double annualIncome,
			boolean accidentDeathBenefit, double accidentDeathCoverage, boolean comprehensiveCare,
			double comprehensiveCareCoverage, int PaymentTenure, String city, String qualification, String occupation,
			String paymentMode) {
		// Basic premium calculation formula
		double basePremium = coverageAmount / 1000;

		// Age-based premium adjustment
		if (age >= 18 && age <= 30) {
			basePremium += 50;
		} else if (age > 30 && age <= 45) {
			basePremium += 75;
		} else if (age > 45 && age <= 60) {
			basePremium += 100;
		} else {
			// Handle age out of range
			basePremium += 150;
		}

		// Smoker premium adjustment
		if (isSmoker) {
			basePremium += 100;
		}

		// Income-based premium adjustment
		if (annualIncome > 500000) {
			basePremium -= 50;
		}

		// Rider premium adjustments
		if (accidentDeathBenefit) {
			basePremium += calculateAccidentDeathBenefitPremium(accidentDeathCoverage);
		}

		if (comprehensiveCare) {
			basePremium += calculateComprehensiveCarePremium(comprehensiveCareCoverage);
		}

		// PaymentTenure-based premium adjustment
		if (PaymentTenure == 80) {
			basePremium += 25;
		} else if (PaymentTenure == 90) {
			basePremium += 30;
		} else if (PaymentTenure == 105) {
			basePremium += 35;
		}

		
		// City-based premium adjustment (Additional premium for a high-risk city)
		if (city.equals("HighRiskCity")) {
			basePremium += 50;
		}

		// Qualification-based premium adjustment (Additional premium for lower qualification)
		if (qualification.equals("LowQualification")) {
			basePremium += 20;
		}

		// Occupation-based premium adjustment (Additional premium for high-risk occupation)
		if (occupation.equals("HighRiskOccupation")) {
			basePremium += 40;
		}

		// Payment mode premium adjustment
		if (paymentMode.equals("HalfYearly")) {
			basePremium -= basePremium * 0.1; // 10% reduction for half-yearly
		} else if (paymentMode.equals("Annual")) {
			basePremium -= basePremium * 0.15; // 15% reduction for annual
		}

		return basePremium;
	}

	private double calculateAccidentDeathBenefitPremium(double coverage) {
		// Calculate premium for Accident Death Benefit based on coverage
		double premium = (coverage - 25000) / 50000 * 10;
		return premium;
		
	}

	private double calculateComprehensiveCarePremium(double coverage) {
		// Calculate premium for Comprehensive Care based on coverage
		double premium = (coverage - 200000) / 300000 * 400;
		return premium;
	}
}
