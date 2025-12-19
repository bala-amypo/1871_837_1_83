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

    // ✅ GETTERS
    public Long getId() { return id; }
    public Vendor getVendor() { return vendor; }
    public SLARequirement getSlaRequirement() { return slaRequirement; }
    public Integer getActualDeliveryDays() { return actualDeliveryDays; }
    public Double getQualityScore() { return qualityScore; }
    public Date getEvaluationDate() { return evaluationDate; }
    public Boolean getMeetsDeliveryTarget() { return meetsDeliveryTarget; }
    public Boolean getMeetsQualityTarget() { return meetsQualityTarget; }

    // ✅ SETTERS
    public void setId(Long id) { this.id = id; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public void setSlaRequirement(SLARequirement slaRequirement) { this.slaRequirement = slaRequirement; }
    public void setActualDeliveryDays(Integer actualDeliveryDays) { this.actualDeliveryDays = actualDeliveryDays; }
    public void setQualityScore(Double qualityScore) { this.qualityScore = qualityScore; }
    public void setEvaluationDate(Date evaluationDate) { this.evaluationDate = evaluationDate; }
    public void setMeetsDeliveryTarget(Boolean meetsDeliveryTarget) { this.meetsDeliveryTarget = meetsDeliveryTarget; }
    public void setMeetsQualityTarget(Boolean meetsQualityTarget) { this.meetsQualityTarget = meetsQualityTarget; }
}
