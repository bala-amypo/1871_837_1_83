package com.example.demo.repository;

import com.example.demo.model.VendorPerformanceScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorPerformanceScoreRepository
        extends JpaRepository<VendorPerformanceScore, Long> {

    // ✅ Correct JPA method
    List<VendorPerformanceScore>
    findByVendor_IdOrderByCalculatedAtDesc(Long vendorId);

    // ✅ TEST COMPATIBILITY METHOD
    default List<VendorPerformanceScore>
    findByVendorOrderByCalculatedAtDesc(Long vendorId) {
        return findByVendor_IdOrderByCalculatedAtDesc(vendorId);
    }
}
