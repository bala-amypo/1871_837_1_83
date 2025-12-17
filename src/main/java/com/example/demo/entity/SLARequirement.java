package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sla_requirements")
public class SLARequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vendorName;

    @Column(nullable = false)
    private String slaType; 
    // Example: DELIVERY_TIME, QUALITY, RESPONSE_TIME

    @Column(nullable = false)
    private Integer thresholdValue;
    // Example: max delivery time in hours

    private String unit;
    // Example: HOURS, DAYS, %

    private LocalDateTime createdAt = LocalDateTime.now();

    // ===== Constructors =====
    public SLARequirement() {}

    public SLARequirement(String vendorName, String slaType, Integer thresholdValue, String unit) {
        this.vendorName = vendorName;
        this.slaType = slaType;
        this.thresholdValue = thresholdValue;
        this.unit = unit;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getSlaType() {
        return slaType;
    }

    public void setSlaType(String slaType) {
        this.slaType = slaType;
    }

    public Integer getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(Integer thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
