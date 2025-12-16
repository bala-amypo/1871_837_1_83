package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_evaluations")
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vendorName;

    @Column(nullable = false)
    private Integer actualValue;
    // Example: actual delivery time

    @Column(nullable = false)
    private boolean slaMet;

    private LocalDateTime evaluatedAt = LocalDateTime.now();

    // ===== Constructors =====
    public DeliveryEvaluation() {}

    public DeliveryEvaluation(String vendorName, Integer actualValue, boolean slaMet) {
        this.vendorName = vendorName;
        this.actualValue = actualValue;
        this.slaMet = slaMet;
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

    public Integer getActualValue() {
        return actualValue;
    }

    public void setActualValue(Integer actualValue) {
        this.actualValue = actualValue;
    }

    public boolean isSlaMet() {
        return slaMet;
    }

    public void setSlaMet(boolean slaMet) {
        this.slaMet = slaMet;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}
