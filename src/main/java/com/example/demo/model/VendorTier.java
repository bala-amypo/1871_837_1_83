package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VendorTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tierName;

    private Double minScoreThreshold;
    private String description;
    private Boolean active = true;

    public Long getId() { return id; }
    public String getTierName() { return tierName; }
    public Double getMinScoreThreshold() { return minScoreThreshold; }
    public String getDescription() { return description; } // ✅ FIX
    public Boolean getActive() { return active; }

    public void setTierName(String tierName) { this.tierName = tierName; }
    public void setMinScoreThreshold(Double minScoreThreshold) { this.minScoreThreshold = minScoreThreshold; }
    public void setDescription(String description) { this.description = description; }
    public void setActive(Boolean active) { this.active = active; }
}
