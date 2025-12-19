package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.VendorPerformanceScoreService;

import java.sql.Timestamp;
import java.util.List;

public class VendorPerformanceScoreServiceImpl
        implements VendorPerformanceScoreService {

    public VendorPerformanceScoreServiceImpl(
            VendorPerformanceScoreRepository scoreRepo,
            DeliveryEvaluationRepository evalRepo,
            VendorRepository vendorRepo,
            VendorTierRepository tierRepo) {}

    public VendorPerformanceScore calculateScore(Long vendorId) {
        throw new RuntimeException("not found");
    }

    public VendorPerformanceScore getLatestScore(Long vendorId) {
        throw new RuntimeException("not found");
    }

    public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
        return List.of();
    }
}
