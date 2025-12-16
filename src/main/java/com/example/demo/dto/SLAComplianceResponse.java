package com.example.demo.dto;

public class SLAComplianceResponse {

    private String vendorName;
    private long totalEvaluations;
    private long slaMetCount;
    private long slaViolatedCount;
    private double compliancePercentage;

    public SLAComplianceResponse(
            String vendorName,
            long totalEvaluations,
            long slaMetCount,
            long slaViolatedCount,
            double compliancePercentage) {
        this.vendorName = vendorName;
        this.totalEvaluations = totalEvaluations;
        this.slaMetCount = slaMetCount;
        this.slaViolatedCount = slaViolatedCount;
        this.compliancePercentage = compliancePercentage;
    }

    public String getVendorName() {
        return vendorName;
    }

    public long getTotalEvaluations() {
        return totalEvaluations;
    }

    public long getSlaMetCount() {
        return slaMetCount;
    }

    public long getSlaViolatedCount() {
        return slaViolatedCount;
    }

    public double getCompliancePercentage() {
        return compliancePercentage;
    }
}
