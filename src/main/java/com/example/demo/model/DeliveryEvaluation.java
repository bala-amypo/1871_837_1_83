package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private SLARequirement slaRequirement;

    private Integer actualDeliveryDays;
    private Double qualityScore;
    private Date evaluationDate;

    private Boolean meetsDeliveryTarget;
    private Boolean meetsQualityTarget;

    // ✅ GETTERS & SETTERS
    public Vendor getVendor() { return vendor; }
    public SLARequirement getSlaRequirement() { return slaRequirement; }
    public Integer getActualDeliveryDays() { return actualDeliveryDays; }
    public Double getQualityScore() { return qualityScore; }

    public void setMeetsDeliveryTarget(Boolean val) { this.meetsDeliveryTarget = val; }
    public void setMeetsQualityTarget(Boolean val) { this.meetsQualityTarget = val; }
}
