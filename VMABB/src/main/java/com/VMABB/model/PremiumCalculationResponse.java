package com.VMABB.model;

public class PremiumCalculationResponse {
    private double premium;

    public PremiumCalculationResponse(double premium) {
        this.premium = premium;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }
}
