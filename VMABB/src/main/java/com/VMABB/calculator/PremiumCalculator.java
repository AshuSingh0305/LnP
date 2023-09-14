package com.VMABB.calculator;

import org.springframework.stereotype.Component;

@Component
public class PremiumCalculator {

	public double calculateTermInsurancePremium(int age, boolean isSmoker, double coverageAmount, double annualIncome) {
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

		return basePremium;
	}
}
