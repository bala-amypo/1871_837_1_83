package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class VendorPerformanceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    private Double onTimePercentage;
    private Double qualityCompliancePercentage;
    private Double overallScore;
    private Timestamp calculatedAt;

    public Long getId() { return id; }
    public Vendor getVendor() { return vendor; }
    public Double getOnTimePercentage() { return onTimePercentage; }
    public Double getQualityCompliancePercentage() { return qualityCompliancePercentage; }
    public Double getOverallScore() { return overallScore; }
    public Timestamp getCalculatedAt() { return calculatedAt; }

    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public void setOnTimePercentage(Double v) { this.onTimePercentage = v; }
    public void setQualityCompliancePercentage(Double v) { this.qualityCompliancePercentage = v; }
    public void setOverallScore(Double v) { this.overallScore = v; }
    public void setCalculatedAt(Timestamp t) { this.calculatedAt = t; }
}
