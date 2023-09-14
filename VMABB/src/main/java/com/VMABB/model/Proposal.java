package com.VMABB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import javax.persistence.*;

@Entity
@Table(name = "proposals")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proposalId;

    @Column(nullable = true)
    private String proposalName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private boolean isSmoker;

    @Column(nullable = false)
    private double lifeCoverAmount;

    @Column(nullable = false)
    private double annualIncome;

    @Column(nullable = false)
    private boolean accidentDeathBenefit;

    @Column(nullable = false)
    private double accidentDeathCoverage;

    @Column(nullable = false)
    private boolean comprehensiveCare;

    @Column(nullable = false)
    private double comprehensiveCareCoverage;

    @Column(nullable = false)
    private int paymentTenure;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String qualification;

    @Column(nullable = false)
    private String occupation;

    @Column(nullable = false)
    private String paymentMode;
    
    private double premium;

    // Add more fields as needed...

    public Proposal() {
        // Default constructor
    }

    public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	// Constructor with all fields
    public Proposal(String proposalName, int age, boolean isSmoker, double lifeCoverAmount,
                    double annualIncome, boolean accidentDeathBenefit, double accidentDeathCoverage,
                    boolean comprehensiveCare, double comprehensiveCareCoverage, int paymentTenure,
                    String city, String qualification, String occupation, String paymentMode) {
        this.proposalName = proposalName;
        this.age = age;
        this.isSmoker = isSmoker;
        this.lifeCoverAmount = lifeCoverAmount;
        this.annualIncome = annualIncome;
        this.accidentDeathBenefit = accidentDeathBenefit;
        this.accidentDeathCoverage = accidentDeathCoverage;
        this.comprehensiveCare = comprehensiveCare;
        this.comprehensiveCareCoverage = comprehensiveCareCoverage;
        this.paymentTenure = paymentTenure;
        this.city = city;
        this.qualification = qualification;
        this.occupation = occupation;
        this.paymentMode = paymentMode;
        // Initialize other fields as needed...
    }

    // Getter and Setter methods for all fields

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public String getProposalName() {
        return proposalName;
    }

    public void setProposalName(String proposalName) {
        this.proposalName = proposalName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public void setIsSmoker(boolean smoker) {
        isSmoker = smoker;
    }

    public double getLifeCoverAmount() {
        return lifeCoverAmount;
    }

    public void setLifeCoverAmount(double lifeCoverAmount) {
        this.lifeCoverAmount = lifeCoverAmount;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public boolean isAccidentDeathBenefit() {
        return accidentDeathBenefit;
    }

    public void setAccidentDeathBenefit(boolean accidentDeathBenefit) {
        this.accidentDeathBenefit = accidentDeathBenefit;
    }

    public double getAccidentDeathCoverage() {
        return accidentDeathCoverage;
    }

    public void setAccidentDeathCoverage(double accidentDeathCoverage) {
        this.accidentDeathCoverage = accidentDeathCoverage;
    }

    public boolean isComprehensiveCare() {
        return comprehensiveCare;
    }

    public void setComprehensiveCare(boolean comprehensiveCare) {
        this.comprehensiveCare = comprehensiveCare;
    }

    public double getComprehensiveCareCoverage() {
        return comprehensiveCareCoverage;
    }

    public void setComprehensiveCareCoverage(double comprehensiveCareCoverage) {
        this.comprehensiveCareCoverage = comprehensiveCareCoverage;
    }

    public int getPaymentTenure() {
        return paymentTenure;
    }

    public void setPaymentTenure(int paymentTenure) {
        this.paymentTenure = paymentTenure;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    // Add getter and setter methods for other fields as needed...
}
