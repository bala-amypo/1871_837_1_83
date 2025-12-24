package com.example.demo.repository;

import com.example.demo.model.VendorPerformanceScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorPerformanceScoreRepository
        extends JpaRepository<VendorPerformanceScore, Long> {

    // ✅ Required by test cases
    List<VendorPerformanceScore> findByVendorOrderByCalculatedAtDesc(Long vendorId);

    // ✅ Spring-safe version (keep existing logic intact)
    List<VendorPerformanceScore> findByVendor_IdOrderByCalculatedAtDesc(Long vendorId);
}
