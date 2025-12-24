package com.example.demo.repository;

import com.example.demo.model.VendorPerformanceScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorPerformanceScoreRepository
        extends JpaRepository<VendorPerformanceScore, Long> {

    // ✅ EXACT method name expected by tests
    List<VendorPerformanceScore> findByVendorOrderByCalculatedAtDesc(Long vendorId);
}
