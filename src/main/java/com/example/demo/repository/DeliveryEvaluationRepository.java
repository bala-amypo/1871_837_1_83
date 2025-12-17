package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DeliveryEvaluation;

public interface DeliveryEvaluationRepository
        extends JpaRepository<DeliveryEvaluation, Long> {

    List<DeliveryEvaluation> findByVendorName(String vendorName);

    long countByVendorName(String vendorName);

    long countByVendorNameAndSlaMetTrue(String vendorName);

    long countByVendorNameAndSlaMetFalse(String vendorName);
}
